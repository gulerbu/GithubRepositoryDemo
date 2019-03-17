
package gulerbu.com.githubrepositorydemo.util.resource

import android.support.annotation.ColorRes
import android.support.annotation.DimenRes
import android.support.annotation.IntegerRes
import android.support.annotation.StringRes


interface IResourceHelper {

    /**
     * Gets string from resources.
     *
     * @param stringResId resource identifier to get string associated with
     * @throws [android.content.res.Resources.NotFoundException] Throws NotFoundException if the given ID does not exist.
     * @return string associated with this identifier
     */
    fun getString(@StringRes stringResId: Int): String

    /**
     * Gets integer from resources. Returns 0 if resource identifier is invalid.
     *
     * @param integerResId resource identifier to get integer associated with
     * @throws [android.content.res.Resources.NotFoundException] Throws NotFoundException if the given ID does not exist.
     * @return integer associated with this identifier. 0 if invalid.
     */
    fun getInteger(@IntegerRes integerResId: Int): Int

    fun getDimensionPixelOffset(@DimenRes dimenResId: Int): Int

    fun getDimension(@DimenRes dimenResId: Int): Float

    fun getDimensionPixelSize(@DimenRes dimenResId: Int): Int

    fun getColor(@ColorRes colorResId: Int): Int
}