
package gulerbu.com.githubrepositorydemo.model

import com.google.gson.annotations.SerializedName


data class RepositoryOwner(
    @SerializedName("login")
    val userName: String,
    @SerializedName("avatar_url")
    val useAvatarUrl: String
)