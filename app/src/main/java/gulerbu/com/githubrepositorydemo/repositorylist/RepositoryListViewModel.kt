package gulerbu.com.githubrepositorydemo.repositorylist

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import gulerbu.com.githubrepositorydemo.R
import gulerbu.com.githubrepositorydemo.core.BaseViewModel
import gulerbu.com.githubrepositorydemo.core.navigation.HasRouter
import gulerbu.com.githubrepositorydemo.core.toolbar.ToolbarOwner
import gulerbu.com.githubrepositorydemo.model.Repository
import gulerbu.com.githubrepositorydemo.ui.ProgressOwner
import gulerbu.com.githubrepositorydemo.util.MutableLiveData
import gulerbu.com.githubrepositorydemo.util.resource.IResourceHelper


class RepositoryListViewModel(
    private val repository: RepositoryListContract.Repository,
    private val resourceHelper: IResourceHelper,
    private val router: RepositoryListContract.Router
) : BaseViewModel(),
    ProgressOwner, HasRouter by router, ToolbarOwner {

    override val inProgress: MutableLiveData<Boolean> = repository.inProgress

    val username = MutableLiveData<String>()

    override val toolbarTitle = MutableLiveData(resourceHelper.getString(R.string.home_page_title))

    val showInfoText = MediatorLiveData<Boolean>().apply {
        addSource(repository.noResult) { value = it }
        addSource(repository.onFailure) { value = it }
    }

    val infoText = MediatorLiveData<String>().apply {
        addSource(repository.noResult) { value = resourceHelper.getString(R.string.search_no_results_text) }
        addSource(repository.onFailure) { value = resourceHelper.getString(R.string.search_error_text) }
    }

    val repositories = repository.repositories

    fun onSearchClick() {
        if (username.value.isNullOrEmpty().not()) {
            repository.getRepositoriesOfUser(username.value!!)
        }

    }

    fun onRepositoryClick(repository: Repository) {
        router.onRepositoryClick(repository)

    }
}