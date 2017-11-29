package net.mino.githubrepofinder.data.mapper

import io.reactivex.functions.Function
import net.mino.githubrepofinder.data.datasource.entity.Item
import net.mino.githubrepofinder.data.datasource.entity.RetrofitOwner
import net.mino.githubrepofinder.data.datasource.entity.RoomRepoInfo

class RoomRepoInfoToModelMapper : Function<RoomRepoInfo, Item> {
    override fun apply(roomRepoInfo: RoomRepoInfo): Item {
        return Item(
                fullName = roomRepoInfo.repoFullName,
                htmlUrl = roomRepoInfo.repoHtmlUrl,
                id = roomRepoInfo.repoId,
                retrofitOwner = RetrofitOwner(
                        login = roomRepoInfo.repoOwnerName
                )
        )
    }
}