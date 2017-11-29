package net.mino.githubrepofinder.di.module

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import dagger.Module
import dagger.Provides
import io.reactivex.Single
import net.mino.githubrepofinder.Constants
import net.mino.githubrepofinder.data.datasource.entity.RetrofitRepoInfo
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query
import javax.inject.Singleton

@Module
class NetworkModule {
    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        return Retrofit.Builder()
                .baseUrl(Constants.NETWORK.HOST.BASE_URL)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create()).build()
    }

    @Singleton
    @Provides
    fun provideGithubRestClient(retrofit: Retrofit): GithubRestClient =
            retrofit.create(GithubRestClient::class.java)


    interface GithubRestClient {
        @GET(Constants.NETWORK.ENDPOINT.SEARCH_REPOSITORIES)
        fun getRepositoriesByKeywords(@Query("q") query: String): Single<Response<RetrofitRepoInfo>>
    }
} 