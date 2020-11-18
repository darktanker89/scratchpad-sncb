package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class StationsResponse(
    @Json(name = "station")
    val stations: List<Station>,
    @Json(name = "timestamp")
    val timestamp: Int,
    @Json(name = "version")
    val version: String
)
