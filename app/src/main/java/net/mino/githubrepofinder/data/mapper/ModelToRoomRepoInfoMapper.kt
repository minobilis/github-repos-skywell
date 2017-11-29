package net.mino.githubrepofinder.data.mapper

import io.reactivex.functions.Function
import net.mino.githubrepofinder.data.datasource.entity.Item
import net.mino.githubrepofinder.data.datasource.entity.RoomRepoInfo

class ModelToRoomRepoInfoMapper : Function<Item, RoomRepoInfo> {
    override fun apply(item: Item): RoomRepoInfo {
        return RoomRepoInfo(
                repoFullName = item.fullName,
                repoHtmlUrl = item.htmlUrl,
                repoId = item.id,
                repoOwnerName = item.retrofitOwner?.login
        )
    }
}