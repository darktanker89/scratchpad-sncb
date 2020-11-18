package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class DisturbancesResponse(
    @Json(name = "disturbance")
    val disturbance: List<ApiDisturbance>,
    @Json(name = "timestamp")
    val timestamp: String,
    @Json(name = "version")
    val version: String
)
