package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class ConnectionsResponse(
    @Json(name = "connection")
    val connection: List<Connection>,
    @Json(name = "timestamp")
    val timestamp: Int,
    @Json(name = "version")
    val version: String
)
