package gulerbu.com.githubrepositorydemo.core.toolbar

import android.arch.lifecycle.LiveData


interface ToolbarOwner {
    val toolbarTitle: LiveData<String>
}