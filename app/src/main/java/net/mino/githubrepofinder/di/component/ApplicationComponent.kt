package net.mino.githubrepofinder.di.component

import dagger.BindsInstance
import dagger.Component
import dagger.android.AndroidInjector
import dagger.android.support.AndroidSupportInjectionModule
import dagger.android.support.DaggerApplication
import net.mino.githubrepofinder.App
import net.mino.githubrepofinder.di.module.ContextModule
import net.mino.githubrepofinder.di.module.DataModule
import net.mino.githubrepofinder.di.module.NetworkModule
import net.mino.githubrepofinder.di.module.RxModule
import net.mino.githubrepofinder.ui.MainActivity
import net.mino.githubrepofinder.ui.RepoFragment
import javax.inject.Singleton

@Singleton
@Component(modules = arrayOf(
        RxModule::class,
        NetworkModule::class,
        DataModule::class,
        ContextModule::class,
        AndroidSupportInjectionModule::class))
interface ApplicationComponent : AndroidInjector<DaggerApplication> {

    @Component.Builder
    interface Builder {

        @BindsInstance
        fun application(application: App): Builder

        fun build(): ApplicationComponent
    }

    fun inject(app: App)
    fun inject(mainActivity: MainActivity)
    fun inject(repoFragment: RepoFragment)
}