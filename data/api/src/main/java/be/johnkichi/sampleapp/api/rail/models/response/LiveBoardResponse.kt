package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class LiveBoardResponse(
    @Json(name = "departures")
    val departures: Departures,
    @Json(name = "station")
    val station: String,
    @Json(name = "stationinfo")
    val stationinfo: Stationinfo,
    @Json(name = "timestamp")
    val timestamp: Int,
    @Json(name = "version")
    val version: String
)
