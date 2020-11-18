package be.johnkichi.sampleapp.api.base

import kotlinx.coroutines.delay

suspend inline fun <T : Any, U : Any> executeWithRetry(
    times: Int = 3,
    initialDelay: Long = 100, // ms
    maxDelay: Long = 1000,
    backOff: Double = 2.0,
    block: () -> NetworkResponse<T, U>
): NetworkResponse<T, U> {
    var currentDelay = initialDelay
    repeat(times - 1) {
        when (val response = block()) {
            is NetworkResponse.NetworkError -> {
                delay(currentDelay)
                currentDelay = (currentDelay * backOff).toLong().coerceAtMost(maxDelay)
            }
            else -> return response
        }
    }
    return block()
}

operator fun <T : Any, U : Any> NetworkResponse<T, U>.invoke(): T? {
    return if (this is NetworkResponse.Success) body else null
}
