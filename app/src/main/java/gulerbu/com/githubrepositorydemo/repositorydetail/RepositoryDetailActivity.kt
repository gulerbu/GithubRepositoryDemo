package gulerbu.com.githubrepositorydemo.repositorydetail

import android.databinding.DataBindingUtil
import android.os.Bundle
import gulerbu.com.githubrepositorydemo.R
import gulerbu.com.githubrepositorydemo.core.BaseActivity
import gulerbu.com.githubrepositorydemo.core.navigation.ActivityNavigation
import gulerbu.com.githubrepositorydemo.databinding.ActivityRepositoryDetailBinding
import gulerbu.com.githubrepositorydemo.model.Repository


class RepositoryDetailActivity : BaseActivity<RepositoryDetailViewModel>() {

    private lateinit var binding: ActivityRepositoryDetailBinding

    override fun getContentLayoutResourceId() = R.layout.activity_repository_detail

    override fun createViewModel() = RepositoryDetailModule.createViewModel(
        this, intent.getParcelableExtra(
            KEY_REPOSITORY
        )
    )

    override fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getContentLayoutResourceId())
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    companion object {

        private const val KEY_REPOSITORY = "repository"

        fun createNavigation(repository: Repository): ActivityNavigation {
            return ActivityNavigation(RepositoryDetailActivity::class.java, Bundle().apply {
                putParcelable(KEY_REPOSITORY, repository)
            })
        }
    }
}