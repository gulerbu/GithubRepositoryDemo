
package gulerbu.com.githubrepositorydemo.repositorylist

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import gulerbu.com.githubrepositorydemo.databinding.LayoutRepositoryListItemBinding
import gulerbu.com.githubrepositorydemo.model.Repository


class RepositoryListAdapter(private val repositoryList: List<Repository>) :
    RecyclerView.Adapter<RepositoryListAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        val binding = LayoutRepositoryListItemBinding.inflate(layoutInflater, parent, false)

        return ViewHolder(binding)
    }

    override fun getItemCount() = repositoryList.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(repositoryList[position])
    }

    inner class ViewHolder(private val binding: LayoutRepositoryListItemBinding) :
        RecyclerView.ViewHolder(binding.root) {

        fun bind(repository: Repository) {
            binding.repository = repository
            binding.executePendingBindings()
        }

    }
}