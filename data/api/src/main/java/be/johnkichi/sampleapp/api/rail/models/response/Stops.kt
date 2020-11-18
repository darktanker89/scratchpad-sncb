package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Stops(
    @Json(name = "number")
    val number: Int,
    @Json(name = "stop")
    val stop: List<Stop>
)
