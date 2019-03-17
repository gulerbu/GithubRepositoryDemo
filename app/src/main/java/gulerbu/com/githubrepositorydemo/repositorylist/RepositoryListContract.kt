
package gulerbu.com.githubrepositorydemo.repositorylist

import android.arch.lifecycle.LiveData
import gulerbu.com.githubrepositorydemo.ui.ProgressOwner


interface RepositoryListContract {

    interface Repository: ProgressOwner {

        fun getRepositoriesOfUser(username: String)

        val repositories: LiveData<List<gulerbu.com.githubrepositorydemo.model.Repository>>

        val onFailure: LiveData<Boolean>

        val noResult: LiveData<Boolean>
    }
}