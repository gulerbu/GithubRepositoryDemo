package gulerbu.com.githubrepositorydemo.core.navigation

import gulerbu.com.githubrepositorydemo.core.BaseActivity


interface Navigation {

    fun navigateFromActivity(activity: BaseActivity<*>)

}