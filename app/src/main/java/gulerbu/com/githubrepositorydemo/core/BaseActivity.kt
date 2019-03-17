package gulerbu.com.githubrepositorydemo.core

import android.os.Bundle
import android.support.annotation.LayoutRes
import android.support.v7.app.AppCompatActivity


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

    /**
     * Performs data binding operation and linking view model with binding instance.
     */
    abstract fun performDataBinding()

    @LayoutRes
    abstract fun getContentLayoutResourceId(): Int

    abstract fun createViewModel(): VM

    abstract fun attachViewModelObservers(viewModel: VM)
}