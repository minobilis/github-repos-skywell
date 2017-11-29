package net.mino.githubrepofinder.di.module

import android.content.Context
import dagger.Binds
import dagger.Module
import net.mino.githubrepofinder.App
import javax.inject.Singleton

@Module
abstract class ContextModule {
    @Singleton
    @Binds
    internal abstract fun provideContext(app: App): Context
} 