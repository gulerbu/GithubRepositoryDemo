package gulerbu.com.githubrepositorydemo.network

import gulerbu.com.githubrepositorydemo.model.Repository
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path


interface RepositoryApi {

    @GET("users/{user}/repos")
    fun getReposOfUser(@Path("user") username: String): Call<List<Repository>>
}