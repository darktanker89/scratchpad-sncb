package be.johnkichi.sampleapp.api.util

import be.johnkichi.sampleapp.api.di.ApiModule
import com.squareup.moshi.JsonAdapter
import okhttp3.mockwebserver.MockResponse

internal fun useJSON(path: String): String {
    return ClassLoader.getSystemResource(path).readText()
}

internal inline fun <reified T> useJSONAdapter(): JsonAdapter<T> {
    val moshi = ApiModule.providesMoshi()
    return moshi.adapter(T::class.java)
}

internal fun MockResponse.fromFile(path: String, responseCode: Int = 200) = this.apply {
    setBody(useJSON(path))
    setResponseCode(responseCode)
}
