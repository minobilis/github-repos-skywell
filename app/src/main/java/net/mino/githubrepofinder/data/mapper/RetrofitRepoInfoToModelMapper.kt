package net.mino.githubrepofinder.data.mapper

import io.reactivex.functions.Function
import net.mino.githubrepofinder.data.datasource.entity.RepoInfo
import net.mino.githubrepofinder.data.datasource.entity.RetrofitRepoInfo

class RetrofitRepoInfoToModelMapper : Function<RetrofitRepoInfo, RepoInfo> {
    override fun apply(retrofitRepoInfo: RetrofitRepoInfo): RepoInfo {
        return RepoInfo(
                retrofitItems = retrofitRepoInfo.retrofitItems
        )
    }
}