package net.mino.githubrepofinder

import com.facebook.stetho.Stetho
import dagger.android.AndroidInjector
import dagger.android.support.DaggerApplication
import net.mino.githubrepofinder.di.component.ApplicationComponent
import net.mino.githubrepofinder.di.component.DaggerApplicationComponent


class App : DaggerApplication() {

    companion object {
        lateinit var appComponent : ApplicationComponent
    }

    override fun applicationInjector(): AndroidInjector<out DaggerApplication> {
        val applicationComponent = DaggerApplicationComponent
                .builder()
                .application(this)
                .build()
        appComponent = applicationComponent
        return applicationComponent
    }

    override fun onCreate() {
        super.onCreate()
        if (BuildConfig.DEBUG) {
            Stetho.initializeWithDefaults(this)
        }
    }
}