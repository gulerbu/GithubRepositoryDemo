package gulerbu.com.githubrepositorydemo.util

import android.arch.lifecycle.ViewModel
import android.arch.lifecycle.ViewModelProvider
import android.arch.lifecycle.ViewModelProviders
import android.support.v4.app.FragmentActivity
import gulerbu.com.githubrepositorydemo.core.BaseViewModel


inline fun <reified VM : BaseViewModel> createViewModel(
    activity: FragmentActivity, crossinline viewModelCreator: () -> VM
): VM {
    return ViewModelProviders
        .of(activity, createFactory(viewModelCreator))
        .get(VM::class.java)
}

inline fun <VM : ViewModel> createFactory(crossinline createViewModel: () -> VM) =
    object : ViewModelProvider.NewInstanceFactory() {
        override fun <T : ViewModel> create(clazz: Class<T>): T = createViewModel() as T
    }
