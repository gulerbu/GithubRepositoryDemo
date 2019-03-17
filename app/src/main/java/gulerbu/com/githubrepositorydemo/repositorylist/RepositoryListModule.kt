package gulerbu.com.githubrepositorydemo.repositorylist

import android.arch.lifecycle.ViewModelProviders
import gulerbu.com.githubrepositorydemo.core.BaseActivity
import gulerbu.com.githubrepositorydemo.util.createFactory
import gulerbu.com.githubrepositorydemo.util.resource.ResourceHelper


object RepositoryListModule {

    fun createViewModel(
        activity: BaseActivity<*>,
        repository: RepositoryListContract.Repository,
        router: RepositoryListContract.Router
    ): RepositoryListViewModel {
        return ViewModelProviders.of(activity, createFactory {
            RepositoryListViewModel(
                repository,
                ResourceHelper,
                router
            )
        }).get(RepositoryListViewModel::class.java)

    }
}