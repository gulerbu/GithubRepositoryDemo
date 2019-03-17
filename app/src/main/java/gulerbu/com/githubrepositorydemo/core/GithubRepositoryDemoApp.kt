
package gulerbu.com.githubrepositorydemo.core

import android.app.Application
import android.support.v7.app.AppCompatDelegate
import com.facebook.drawee.backends.pipeline.Fresco


class GithubRepositoryDemoApp : Application() {

    override fun onCreate() {
        super.onCreate()
        instance = this
        AppCompatDelegate.setCompatVectorFromResourcesEnabled(true)
        Fresco.initialize(this)
    }

    companion object {
        lateinit var instance: GithubRepositoryDemoApp
    }
}