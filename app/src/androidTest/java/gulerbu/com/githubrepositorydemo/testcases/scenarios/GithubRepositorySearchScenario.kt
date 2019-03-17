package gulerbu.com.githubrepositorydemo.testcases.scenarios

import android.support.test.espresso.Espresso.onView
import android.support.test.espresso.action.ViewActions
import android.support.test.espresso.action.ViewActions.click
import android.support.test.espresso.action.ViewActions.closeSoftKeyboard
import android.support.test.espresso.assertion.ViewAssertions.matches
import android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition
import android.support.test.espresso.matcher.ViewMatchers.isDisplayed
import android.support.test.espresso.matcher.ViewMatchers.withId
import android.support.v7.widget.RecyclerView
import gulerbu.com.githubrepositorydemo.R
import gulerbu.com.githubrepositorydemo.core.EspressoUtil
import gulerbu.com.githubrepositorydemo.data.MockTestData
import org.hamcrest.Matchers.allOf


object GithubRepositorySearchScenario {


    fun searchInvalidUsername() {
        searchRepositories(MockTestData.INVALID_USERNAME)
        checkErrorText()
    }


    fun searchValidUsername() {
        searchRepositories(MockTestData.USERNAME)
        checkRecyclerview()
    }

    fun openRepositoryDetail() {
        searchRepositories(MockTestData.USERNAME)
        clickRepositoryItem()
        checkRepositoryDetailScreen()
    }

    private fun searchRepositories(username: String) {
        val textInputEditText =
            onView(allOf(withId(R.id.activity_repository_list_edit_text_user), isDisplayed()))
        textInputEditText.perform(ViewActions.typeText(username), closeSoftKeyboard())

        onView(allOf(withId(R.id.activity_repository_list_button_search), isDisplayed())).perform(click())
    }

    private fun clickRepositoryItem() {
        EspressoUtil.waitForView(R.id.activity_repository_list_recycler_view)
        onView(withId(R.id.activity_repository_list_recycler_view)).perform(
            actionOnItemAtPosition<RecyclerView.ViewHolder>(
                0,
                click()
            )
        )
    }

    private fun checkRepositoryDetailScreen() {
        onView(withId(R.id.activity_repository_detail_text_view_username)).check(matches(isDisplayed()))

    }

    private fun checkErrorText() {
        EspressoUtil.waitForView(R.id.activity_repository_list_text_view_info)
    }

    private fun checkRecyclerview() {
        EspressoUtil.waitForView(R.id.activity_repository_list_recycler_view)
    }
}