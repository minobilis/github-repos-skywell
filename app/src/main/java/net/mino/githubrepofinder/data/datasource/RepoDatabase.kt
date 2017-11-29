package net.mino.githubrepofinder.data.datasource

import android.arch.persistence.room.Database
import android.arch.persistence.room.RoomDatabase
import net.mino.githubrepofinder.data.datasource.entity.RoomRepoInfo

@Database(entities = arrayOf(RoomRepoInfo::class), version = 1, exportSchema = false)
abstract class RepoDatabase : RoomDatabase() {
    abstract fun repoInfoDao(): RepoInfoDao
}