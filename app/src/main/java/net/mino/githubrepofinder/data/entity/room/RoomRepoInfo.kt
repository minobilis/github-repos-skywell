package net.mino.githubrepofinder.data.datasource.entity

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity(tableName = RoomRepoInfo.TABLE_NAME)
data class RoomRepoInfo(
        @PrimaryKey
        var repoId: Int? = null,
        var repoFullName: String? = null,
        var repoHtmlUrl: String? = null,
        var repoOwnerName: String? = null) {

        companion object {
            const val TABLE_NAME = "repo_info"
        }
}
