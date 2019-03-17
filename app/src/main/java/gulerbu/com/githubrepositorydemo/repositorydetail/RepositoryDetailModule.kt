package gulerbu.com.githubrepositorydemo.repositorydetail

import android.arch.lifecycle.ViewModelProviders
import gulerbu.com.githubrepositorydemo.core.BaseActivity
import gulerbu.com.githubrepositorydemo.model.Repository
import gulerbu.com.githubrepositorydemo.util.createFactory


object RepositoryDetailModule {

    fun createViewModel(activity: BaseActivity<*>, repository: Repository
    ): RepositoryDetailViewModel {
        return ViewModelProviders.of(activity, createFactory {
            RepositoryDetailViewModel(
                repository
            )
        }).get(RepositoryDetailViewModel::class.java)
    }
}