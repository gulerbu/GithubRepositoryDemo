package gulerbu.com.githubrepositorydemo.repositorylist

import android.databinding.DataBindingUtil
import android.support.v7.widget.LinearLayoutManager
import gulerbu.com.githubrepositorydemo.R
import gulerbu.com.githubrepositorydemo.core.BaseActivity
import gulerbu.com.githubrepositorydemo.databinding.ActivityRepositoryListBinding
import gulerbu.com.githubrepositorydemo.util.observe


class RepositoryListActivity : BaseActivity<RepositoryListViewModel>() {

    lateinit var binding: ActivityRepositoryListBinding

    override fun getContentLayoutResourceId() = R.layout.activity_repository_list

    override fun createViewModel(): RepositoryListViewModel =
        RepositoryListModule.createViewModel(this, RepositoryListRepository(), RepositoryListRouter())

    override fun performDataBinding() {
        binding = DataBindingUtil.setContentView(this, getContentLayoutResourceId())
        binding.viewModel = viewModel
        binding.lifecycleOwner = this
    }

    override fun initUserInterface() {
        super.initUserInterface()
        binding.activityRepositoryListRecyclerView.layoutManager = LinearLayoutManager(this)

    }

    override fun attachViewModelObservers(viewModel: RepositoryListViewModel) {
        super.attachViewModelObservers(viewModel)
        viewModel.repositories.observe(this) {

            binding.activityRepositoryListRecyclerView.adapter = RepositoryListAdapter(it).apply {
                onItemClick = { repository -> viewModel.onRepositoryClick(repository) }
            }
        }

    }
}
