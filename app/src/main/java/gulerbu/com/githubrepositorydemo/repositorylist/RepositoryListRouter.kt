package gulerbu.com.githubrepositorydemo.repositorylist

import gulerbu.com.githubrepositorydemo.model.Repository
import gulerbu.com.githubrepositorydemo.repositorydetail.RepositoryDetailActivity


class RepositoryListRouter: RepositoryListContract.Router() {
    override fun onRepositoryClick(repository: Repository) {
        routingState.value = RepositoryDetailActivity.createNavigation(repository)
    }
}