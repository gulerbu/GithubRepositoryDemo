package gulerbu.com.githubrepositorydemo.core.navigation

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import gulerbu.com.githubrepositorydemo.core.BaseActivity


/**
 * Navigation data class, contains required navigation info for activity navigation
 *
 * [clazz] is used for creating Intent instance
 * [bundle] contains extra info, is added to intent as extras
 * [requestCode] is an optional parameter and intended to use with startActivityForResult
 * [flags] are special intent flags, that controls how intent to be handled
 */
data class ActivityNavigation(
    private val clazz: Class<*>,
    private val bundle: Bundle? = null,
    var requestCode: Int? = null,
    val flags: Int? = null
) : Navigation {

    override fun navigateFromActivity(activity: BaseActivity<*>) {
        requestCode?.let { activity.startActivityForResult(getIntent(activity), it) }
            ?: activity.startActivity(getIntent(activity))
    }

    private fun getIntent(activity: Activity) = Intent(activity, clazz).also {
        if (bundle != null) {
            it.putExtras(bundle)
        }

        if (flags != null) {
            it.flags = flags
        }
    }

}
