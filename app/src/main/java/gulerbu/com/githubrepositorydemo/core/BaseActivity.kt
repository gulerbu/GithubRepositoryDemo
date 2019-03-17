package gulerbu.com.githubrepositorydemo.core

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity
import gulerbu.com.githubrepositorydemo.core.navigation.HasRouter
import gulerbu.com.githubrepositorydemo.core.toolbar.ToolbarOwner
import gulerbu.com.githubrepositorydemo.core.toolbar.UpClickOwner
import gulerbu.com.githubrepositorydemo.util.observe


abstract class BaseActivity<VM : BaseViewModel> : AppCompatActivity() {

    protected lateinit var viewModel: VM
        private set

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = createViewModel()

        performDataBinding()

        initUserInterface()

        attachViewModelObservers(viewModel)
    }

    /**
     * Use this method to init UI in child classes
     */

    open fun initUserInterface() {}

    open fun attachViewModelObservers(viewModel: VM) {
        if (viewModel is HasRouter) {
            viewModel.routingState.observe(this) { it.navigateFromActivity(this) }
        }

        if (viewModel is ToolbarOwner) {
            viewModel.toolbarTitle.observe(this) { supportActionBar?.title = it }
            if (viewModel is UpClickOwner) {
                supportActionBar?.setDisplayHomeAsUpEnabled(true)
            }
        }
    }

    /**
     * Performs data binding operation and linking view model with binding instance.
     */
    abstract fun performDataBinding()

    @LayoutRes
    abstract fun getContentLayoutResourceId(): Int

    abstract fun createViewModel(): VM

}