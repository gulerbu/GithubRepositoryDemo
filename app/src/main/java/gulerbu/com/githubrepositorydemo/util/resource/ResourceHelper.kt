
package gulerbu.com.githubrepositorydemo.util.resource

import android.support.v4.content.res.ResourcesCompat
import gulerbu.com.githubrepositorydemo.core.GithubRepositoryDemoApp


object ResourceHelper : IResourceHelper {

    private val resources
        get() = GithubRepositoryDemoApp.instance.applicationContext.resources

    override fun getString(stringResId: Int): String = resources.getString(stringResId)

    override fun getDimensionPixelOffset(dimenResId: Int): Int = resources.getDimensionPixelOffset(dimenResId)

    override fun getDimension(dimenResId: Int): Float = resources.getDimension(dimenResId)

    override fun getDimensionPixelSize(dimenResId: Int): Int = resources.getDimensionPixelSize(dimenResId)

    override fun getColor(colorResId: Int): Int = ResourcesCompat.getColor(resources, colorResId, null)

    override fun getInteger(integerResId: Int) = resources.getInteger(integerResId)

}