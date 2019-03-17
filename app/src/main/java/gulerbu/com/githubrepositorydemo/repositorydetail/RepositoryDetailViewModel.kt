package gulerbu.com.githubrepositorydemo.repositorydetail

import gulerbu.com.githubrepositorydemo.core.BaseViewModel
import gulerbu.com.githubrepositorydemo.core.toolbar.ToolbarOwner
import gulerbu.com.githubrepositorydemo.core.toolbar.UpClickOwner
import gulerbu.com.githubrepositorydemo.model.Repository
import gulerbu.com.githubrepositorydemo.util.MutableLiveData


class RepositoryDetailViewModel(val repository: Repository) : BaseViewModel(), ToolbarOwner, UpClickOwner {

    override val toolbarTitle = MutableLiveData(repository.name)
}