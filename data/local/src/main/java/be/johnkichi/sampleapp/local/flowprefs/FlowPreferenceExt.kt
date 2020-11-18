package be.johnkichi.sampleapp.local

import com.tfcporciuncula.flow.Preference
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.onEach

// @OptIn(ExperimentalCoroutinesApi::class)
fun <T> Preference<T>.asImmediateFlow(block: (value: T) -> Unit): Flow<T> {
    block(get())
    return asFlow()
        .onEach { block(it) }
}

operator fun <T> Preference<Set<T>>.plusAssign(item: T) {
    set(get() + item)
}

operator fun <T> Preference<Set<T>>.minusAssign(item: T) {
    set(get() - item)
}
