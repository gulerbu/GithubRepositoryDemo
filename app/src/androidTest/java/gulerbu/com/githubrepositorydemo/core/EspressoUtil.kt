package gulerbu.com.githubrepositorydemo.core

import android.support.annotation.IdRes
import android.support.test.espresso.Espresso
import android.support.test.espresso.NoMatchingViewException
import android.support.test.espresso.matcher.ViewMatchers
import android.view.View
import org.hamcrest.Matcher


object EspressoUtil {
    private const val TIME_FOR_RETRY_IN_MILLIS_INITIAL_DEFAULT = 200L
    private const val TIMEOUT_DURATION_IN_MILLIS_INITIAL_DEFAULT = 15000L


    /**
     * Waits for a view to be matched with given [resourceId] within the time frame of [timeout]
     */
    fun waitForView(
        @IdRes resourceId: Int,
        timeout: Long = TIMEOUT_DURATION_IN_MILLIS_INITIAL_DEFAULT
    ) {
        waitForCondition(ViewMatchers.withId(resourceId), timeout) { it != null }

    }


    /**
     * Waits for the given [condition] is satisfied,
     * with the view matched with given [matcher] within the time frame of [timeout]
     */
    fun waitForCondition(
        matcher: Matcher<View>,
        timeout: Long = TIMEOUT_DURATION_IN_MILLIS_INITIAL_DEFAULT,
        condition: (View?) -> Boolean
    ) {

        require(timeout > 0) { "Timeout must be greater than zero" }

        var success = false
        lateinit var exception: NoMatchingViewException
        val loopCount = timeout / TIME_FOR_RETRY_IN_MILLIS_INITIAL_DEFAULT
        (0..loopCount).forEach {
            Espresso.onView(matcher).check { view, noViewFoundException ->
                if (condition(view)) {
                    success = true
                    return@check
                } else {
                    Thread.sleep(TIME_FOR_RETRY_IN_MILLIS_INITIAL_DEFAULT)
                    exception = noViewFoundException
                }
            }

            if (success) {
                return
            }
        }
        throw exception
    }
}