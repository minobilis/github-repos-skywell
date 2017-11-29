package net.mino.githubrepofinder.ui

import android.content.SharedPreferences
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import io.reactivex.Single
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.rxkotlin.toFlowable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.repo_fragment.*
import net.mino.githubrepofinder.App
import net.mino.githubrepofinder.Constants
import net.mino.githubrepofinder.R
import net.mino.githubrepofinder.data.datasource.RepoDatabase
import net.mino.githubrepofinder.data.datasource.entity.RetrofitRepoInfo
import net.mino.githubrepofinder.data.datasource.entity.RoomRepoInfo
import net.mino.githubrepofinder.data.mapper.ModelToRoomRepoInfoMapper
import net.mino.githubrepofinder.data.mapper.RetrofitItemToModelMapper
import net.mino.githubrepofinder.di.module.NetworkModule
import org.jetbrains.anko.support.v4.toast
import retrofit2.Response
import javax.inject.Inject


class RepoFragment : Fragment() {
    @Inject lateinit var client: NetworkModule.GithubRestClient
    @Inject lateinit var compositeDisposable: CompositeDisposable
    @Inject lateinit var retrofitItemToModelMapper: RetrofitItemToModelMapper
    @Inject lateinit var modelToRoomRepoInfoMapper: ModelToRoomRepoInfoMapper
    @Inject lateinit var sharedPreferences: SharedPreferences
    @Inject lateinit var repoDatabase: RepoDatabase
    private var searchInProgress = false

    private val adapter: RepoInfoAdapter = RepoInfoAdapter(mutableListOf())
    private val dataset: MutableList<RoomRepoInfo> =  mutableListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        retainInstance = true
    }

    override fun onCreateView(inflater: LayoutInflater?, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        App.appComponent.inject(this)
        return inflater?.inflate(R.layout.repo_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        adapter.swap(dataset)

        textInputLayout.hint = "Enter repo keyword to search..."
        recycleView.layoutManager = LinearLayoutManager(activity)
        recycleView.adapter = adapter

        btnStartSearch.setOnClickListener {
            if (etInputField.text.toString() == "") {
                toast("Empty query! Please enter something to look for.")

            } else if (!searchInProgress) {
                beginSearch()

            } else {
                resetSearch()
            }
        }
    }

    private fun beginSearch() {
        compositeDisposable.clear()
        searchInProgress = true
        btnStartSearch.text = getString(R.string.searching_is_in_progress)

        if (getLastQueryKeyword() == "" || getLastQueryKeyword() != getKeyword()) {
            updateCacheWithFreshSearchData()
        } else {
            resetSearch()
        }

        showResultToUser()
    }

    private fun updateCacheWithFreshSearchData() {
        compositeDisposable.add(
                Single.amb(listOf(getSearchRepoSingle(), getSearchRepoSingle()))
                        .observeOn(Schedulers.io())
                        .doOnSuccess{
                            if (it.isSuccessful) {
                                repoDatabase.repoInfoDao().deleteAll()
                            }
                        }
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribeBy(
                                onSuccess = { infoRetrofit: Response<RetrofitRepoInfo>? ->
                                    if (infoRetrofit?.isSuccessful == true) {
                                        processResult(infoRetrofit)
                                    }
                                    resetSearch()
                                },
                                onError = { e ->
                                    toast("Error at getting github repositories data.")
                                    e.printStackTrace()
                                    resetSearch()
                                }))
    }

    private fun processResult(infoRetrofit: Response<RetrofitRepoInfo>) {
        infoRetrofit.body()?.retrofitItems?.toFlowable()
                ?.subscribeOn(Schedulers.io())
                ?.map(retrofitItemToModelMapper)
                ?.map(modelToRoomRepoInfoMapper)
                ?.subscribeBy(
                        onNext = { roomRepoInfo ->
                            saveToDiskCache(roomRepoInfo)
                        },
                        onError = { throwable ->
                            throwable.printStackTrace()
                        }
                )
    }

    private fun saveToDiskCache(roomRepoInfo: RoomRepoInfo?) {
        updateLastQueryKeyword()
        if (roomRepoInfo != null) {
            repoDatabase.repoInfoDao().insert(roomRepoInfo)
        }
    }

    private fun getKeyword() = etInputField.text.toString()

    private fun updateLastQueryKeyword() {
        sharedPreferences
                .edit()
                .putString(Constants.PREFERENCES.LAST_QUERY, getKeyword())
                .apply()
    }

    private fun getLastQueryKeyword(): String {
        return sharedPreferences
                .getString(Constants.PREFERENCES.LAST_QUERY, "")
    }

    private fun getSearchRepoSingle() = client.getRepositoriesByKeywords(getKeyword())
            .subscribeOn(Schedulers.computation())

    private fun showResultToUser() {
        repoDatabase.repoInfoDao().getAll()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = {list ->
                            dataset.clear()
                            dataset.addAll(list)
                            (recycleView.adapter as RepoInfoAdapter).swap(list)
                        },
                        onError = {
                            toast("Error retrieving cache data")
                        }
                )
    }

    private fun resetSearch() {
        searchInProgress = false
        btnStartSearch.text = getString(R.string.start_search)
        compositeDisposable.clear()
    }
}
