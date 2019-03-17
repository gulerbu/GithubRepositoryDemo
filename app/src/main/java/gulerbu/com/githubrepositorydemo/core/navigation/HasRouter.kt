package gulerbu.com.githubrepositorydemo.core.navigation

import android.arch.lifecycle.MutableLiveData


interface HasRouter {

    val routingState : MutableLiveData<Navigation>

}