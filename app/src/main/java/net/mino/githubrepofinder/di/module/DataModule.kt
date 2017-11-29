package net.mino.githubrepofinder.di.module

import android.arch.persistence.room.Room
import android.content.Context
import android.content.SharedPreferences
import android.preference.PreferenceManager
import dagger.Module
import dagger.Provides
import net.mino.githubrepofinder.data.datasource.RepoDatabase
import javax.inject.Singleton

@Module
class DataModule {
    @Singleton
    @Provides
    fun provideRepoDatabase(context : Context): RepoDatabase {
        return Room
                .databaseBuilder(context.applicationContext, RepoDatabase::class.java, "repository_info_database")
                .build()
    }

    @Singleton
    @Provides
    fun provideSharedPreferences(context : Context): SharedPreferences {
        return PreferenceManager.getDefaultSharedPreferences(context)
    }
} 