package gulerbu.com.githubrepositorydemo.core.navigation

import android.arch.lifecycle.MutableLiveData
import gulerbu.com.githubrepositorydemo.core.SingleLiveEvent


abstract class BaseRouter : HasRouter {

    override val routingState: MutableLiveData<Navigation> = SingleLiveEvent()

}