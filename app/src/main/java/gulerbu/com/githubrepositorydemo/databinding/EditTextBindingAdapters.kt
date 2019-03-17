
package gulerbu.com.githubrepositorydemo.databinding

import android.databinding.BindingAdapter
import android.databinding.InverseBindingAdapter
import android.databinding.InverseBindingListener
import android.databinding.adapters.ListenerUtil
import android.databinding.adapters.TextViewBindingAdapter
import android.support.v7.widget.AppCompatEditText
import android.text.Editable
import android.text.TextWatcher
import com.android.databinding.library.baseAdapters.R


@BindingAdapter("text")
fun setDistinctText(editText: AppCompatEditText, text: CharSequence?) {
    if (editText.text != text) {
        editText.setText(text.toString())
    }
}

@InverseBindingAdapter(attribute = "text")
fun getText(editText: AppCompatEditText): String? = editText.text.toString()

@BindingAdapter("afterTextValueChanged", "textAttrChanged", requireAll = false)
fun setTextChangedListener(
    editText: AppCompatEditText,
    afterTextChanged: TextViewBindingAdapter.AfterTextChanged?,
    textAttrChanged: InverseBindingListener?) {

    val newWatcher =
        if (afterTextChanged == null && textAttrChanged == null) {
            null
        } else {
            object : TextWatcher {
                override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}

                override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                    textAttrChanged?.onChange()
                }

                override fun afterTextChanged(s: Editable?) {
                    afterTextChanged?.afterTextChanged(s)
                }
            }
        }

    val oldWatcher = ListenerUtil.trackListener(editText, newWatcher, R.id.textWatcher)
    if (oldWatcher != null) {
        editText.removeTextChangedListener(oldWatcher)
    }
    if (newWatcher != null) {
        editText.addTextChangedListener(newWatcher)
    }


}

interface AfterTextChanged {
    fun afterTextChanged(s: Editable?)
}