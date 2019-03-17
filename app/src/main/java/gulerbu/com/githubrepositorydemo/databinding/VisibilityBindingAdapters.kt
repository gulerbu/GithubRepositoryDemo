
package gulerbu.com.githubrepositorydemo.databinding

import android.databinding.BindingAdapter
import android.view.View

@BindingAdapter("viewVisibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}