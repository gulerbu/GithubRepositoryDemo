
package gulerbu.com.githubrepositorydemo.ui

import android.arch.lifecycle.MutableLiveData


interface ProgressOwner {

    val inProgress: MutableLiveData<Boolean>
}