package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Via(
    @Json(name = "arrival")
    val arrival: Arrival,
    @Json(name = "departure")
    val departure: Departure,
    @Json(name = "direction")
    val direction: Direction,
    @Json(name = "id")
    val id: String,
    @Json(name = "station")
    val station: String,
    @Json(name = "stationinfo")
    val stationinfo: Stationinfo,
    @Json(name = "timeBetween")
    val timeBetween: Int,
    @Json(name = "vehicle")
    val vehicle: String
)
