package gulerbu.com.githubrepositorydemo.testcases

import android.support.test.filters.LargeTest
import android.support.test.rule.ActivityTestRule
import android.support.test.runner.AndroidJUnit4
import gulerbu.com.githubrepositorydemo.repositorylist.RepositoryListActivity
import gulerbu.com.githubrepositorydemo.testcases.scenarios.GithubRepositorySearchScenario
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
@LargeTest
class GitHubRepositoryTest {

    @Rule
    @JvmField
    var intentsTestRule: ActivityTestRule<RepositoryListActivity> = ActivityTestRule(RepositoryListActivity::class.java)

    @Test
    fun searchInvalidUsername() {
        GithubRepositorySearchScenario.searchInvalidUsername()
    }

    @Test
    fun searchValidUsername() {
        GithubRepositorySearchScenario.searchValidUsername()
    }

    @Test
    fun openRepositoryDetailPage() {
        GithubRepositorySearchScenario.openRepositoryDetail()
    }

}