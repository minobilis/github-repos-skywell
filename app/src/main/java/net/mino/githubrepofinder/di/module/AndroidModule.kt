package net.mino.githubrepofinder.di.module


import dagger.Module
import dagger.android.ContributesAndroidInjector
import net.mino.githubrepofinder.ui.MainActivity

@Module
abstract class AndroidModule {
    @ContributesAndroidInjector(modules = arrayOf(NetworkModule::class))
    internal abstract fun mainActivityInjector(): MainActivity
}
