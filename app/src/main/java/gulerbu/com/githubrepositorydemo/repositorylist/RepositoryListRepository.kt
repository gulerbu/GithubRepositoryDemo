
package gulerbu.com.githubrepositorydemo.repositorylist

import android.arch.lifecycle.MutableLiveData
import gulerbu.com.githubrepositorydemo.model.Repository
import gulerbu.com.githubrepositorydemo.network.RetrofitClient
import gulerbu.com.githubrepositorydemo.util.MutableLiveData
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class RepositoryListRepository : RepositoryListContract.Repository {

    override val inProgress = MutableLiveData<Boolean>()

    override val repositories: MutableLiveData<List<Repository>> = MutableLiveData(emptyList())

    override val noResult = MutableLiveData(false)

    override val onFailure = MutableLiveData<Boolean>()

    override fun getRepositoriesOfUser(username: String) {
        initSendingRequest()

        RetrofitClient.getRepositoryApi().getReposOfUser(username).enqueue(object :
            Callback<List<Repository>> {
            override fun onFailure(call: Call<List<Repository>>, t: Throwable) {
                inProgress.value = false
                onFailure.value = true
            }

            override fun onResponse(call: Call<List<Repository>>, response: Response<List<Repository>>) {
                inProgress.value = false

                noResult.value = response.body().isNullOrEmpty()
                repositories.value = response.body()

            }

        })
    }

    private fun initSendingRequest() {
        inProgress.value = true
        onFailure.value = false
        noResult.value = false
    }
}