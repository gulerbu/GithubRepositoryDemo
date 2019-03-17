package gulerbu.com.githubrepositorydemo.repositorylist

import android.arch.lifecycle.ViewModelProviders
import gulerbu.com.githubrepositorydemo.core.BaseActivity
import gulerbu.com.githubrepositorydemo.util.createFactory
import gulerbu.com.githubrepositorydemo.util.resource.ResourceHelper


object RepositoryListModule {

    fun createViewModel(
        activity: BaseActivity<*>,
        repository: RepositoryListContract.Repository
    ): RepositoryListActivityViewModel {
        return ViewModelProviders.of(activity, createFactory {
            RepositoryListActivityViewModel(
                repository,
                ResourceHelper
            )
        }).get(RepositoryListActivityViewModel::class.java)

    }
}