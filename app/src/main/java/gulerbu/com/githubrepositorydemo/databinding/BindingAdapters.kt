
package gulerbu.com.githubrepositorydemo.databinding

import android.databinding.BindingAdapter
import android.view.View
import com.facebook.drawee.view.SimpleDraweeView

@BindingAdapter("viewVisibility")
fun setVisibility(view: View, visible: Boolean) {
    view.visibility = if (visible) View.VISIBLE else View.GONE
}

@BindingAdapter("imageUrl")
fun setImageUrl(imageView: SimpleDraweeView, url: String) {
    imageView.setImageURI(url)

}