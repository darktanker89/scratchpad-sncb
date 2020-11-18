package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Alternative(
    @Json(name = "@language")
    val language: String,
    @Json(name = "@value")
    val value: String
)
