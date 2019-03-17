
package gulerbu.com.githubrepositorydemo.core

import android.app.Application
import android.support.v7.app.AppCompatDelegate


class GithubRepositoryDemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
    }

    companion object {
        lateinit var instance: GithubRepositoryDemoApp
    }
}