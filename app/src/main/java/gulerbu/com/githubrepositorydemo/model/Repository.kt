package gulerbu.com.githubrepositorydemo.model

import com.google.gson.annotations.SerializedName


data class Repository(
    @SerializedName("id")
    val id: Long,
    @SerializedName("name")
    val name: String,
    @SerializedName("owner")
    val owner: RepositoryOwner,
    @SerializedName("open_issues_count")
    val openIssuesCount: Int,
    @SerializedName("stargazers_count")
    val starsCount: Int
)