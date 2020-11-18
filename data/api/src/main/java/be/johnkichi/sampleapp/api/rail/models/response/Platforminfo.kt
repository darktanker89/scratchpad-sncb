package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Platforminfo(
    @Json(name = "name")
    val name: String,
    @Json(name = "normal")
    val normal: String
)
