package net.mino.githubrepofinder.data.datasource

import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.OnConflictStrategy
import android.arch.persistence.room.Query
import io.reactivex.Flowable
import net.mino.githubrepofinder.data.datasource.entity.RoomRepoInfo

@Dao
interface RepoInfoDao {
    @Query("SELECT * FROM " + RoomRepoInfo.TABLE_NAME)
    fun getAll() : Flowable<MutableList<RoomRepoInfo>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(roomRepoInfo: List<RoomRepoInfo>): LongArray

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(roomRepoInfo: RoomRepoInfo): Long

    @Query("DELETE FROM " + RoomRepoInfo.TABLE_NAME)
    fun deleteAll()
}