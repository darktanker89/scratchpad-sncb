package be.johnkichi.sampleapp.features.search

import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.channels.awaitClose
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.callbackFlow
import kotlinx.coroutines.flow.map

@FlowPreview
@ExperimentalCoroutinesApi
fun EditText.textChanges(): Flow<String> = callbackFlow<CharSequence> {
    val textWatcher = object : TextWatcher {
        override fun afterTextChanged(p0: Editable?) = Unit

        override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) = Unit

        override fun onTextChanged(text: CharSequence, p1: Int, p2: Int, p3: Int) {
            channel.offer(text)
        }
    }

    this@textChanges.addTextChangedListener(textWatcher)
    awaitClose { this@textChanges.removeTextChangedListener(textWatcher) }
}.map { seq -> seq.toString() }
