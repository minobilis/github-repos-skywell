package net.mino.githubrepofinder.di.module

import dagger.Module
import dagger.Provides
import io.reactivex.disposables.CompositeDisposable
import net.mino.githubrepofinder.data.mapper.ModelToRoomRepoInfoMapper
import net.mino.githubrepofinder.data.mapper.RetrofitItemToModelMapper

@Module
class RxModule {

    @Provides
    fun provideCompositeDisposable() : CompositeDisposable = CompositeDisposable()

    @Provides
    fun provideRetrofitItemToModelMapper() : RetrofitItemToModelMapper = RetrofitItemToModelMapper()

    @Provides
    fun provideModelToRoomRepoInfoMapper() : ModelToRoomRepoInfoMapper = ModelToRoomRepoInfoMapper()
} 