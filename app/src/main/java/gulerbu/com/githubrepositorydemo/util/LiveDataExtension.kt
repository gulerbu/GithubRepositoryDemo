
package gulerbu.com.githubrepositorydemo.util

import android.arch.lifecycle.LifecycleOwner
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.Observer

fun <T> MutableLiveData(initialValue: T) = MutableLiveData<T>().apply { setValue(initialValue) }

fun <T> LiveData<T>.observe(owner: LifecycleOwner, action: (T) -> Unit) {
    observe(owner, Observer { action(it!!) })

}


