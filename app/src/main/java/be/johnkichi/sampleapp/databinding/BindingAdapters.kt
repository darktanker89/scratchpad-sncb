package be.johnkichi.sampleapp.databinding

import android.view.View
import android.widget.Button
import androidx.databinding.BindingAdapter
import kotlinx.coroutines.CoroutineScope

@BindingAdapter("android:onClick", "scope")
fun setDebouncedListener(
    view: Button,
    onClickListener: View.OnClickListener,
    coroutineScope: CoroutineScope
) {
    val clickWithDebounce: (view: View) -> Unit = {
        debounce<View>(scope = coroutineScope) {
            onClickListener.onClick(it)
        }
    }
    view.setOnClickListener(clickWithDebounce)
}

// // +     <variable
// //        name="coroutineScope"
// //        type="kotlinx.coroutines.CoroutineScope" /> in xml
// //      app:scope="@{coroutineScope}"
