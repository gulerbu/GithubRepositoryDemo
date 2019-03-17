
package gulerbu.com.githubrepositorydemo.repositorylist

import android.arch.lifecycle.MediatorLiveData
import android.arch.lifecycle.MutableLiveData
import gulerbu.com.githubrepositorydemo.R
import gulerbu.com.githubrepositorydemo.core.BaseViewModel
import gulerbu.com.githubrepositorydemo.ui.ProgressOwner
import gulerbu.com.githubrepositorydemo.util.resource.IResourceHelper


class RepositoryListActivityViewModel(private val repository: RepositoryListContract.Repository,
                                      private val resourceHelper: IResourceHelper) : BaseViewModel(), ProgressOwner {

    override val inProgress: MutableLiveData<Boolean> = repository.inProgress

    val username = MutableLiveData<String>()

    val showInfoText = MediatorLiveData<Boolean>().apply {
        addSource(repository.noResult) {value = it}
        addSource(repository.onFailure) {value = it}
    }

    val infoText = MediatorLiveData<String>().apply {
        addSource(repository.noResult) { value = resourceHelper.getString(R.string.search_no_results_text) }
        addSource(repository.onFailure) { value = resourceHelper.getString(R.string.search_error_text)}
    }

    val repositories = repository.repositories

    fun onSearchClick() {
        if (username.value.isNullOrEmpty().not()) {
            repository.getRepositoriesOfUser(username.value!!)
        }

    }
}