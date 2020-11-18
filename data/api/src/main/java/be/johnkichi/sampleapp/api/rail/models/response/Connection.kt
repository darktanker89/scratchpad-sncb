package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Connection(
    @Json(name = "alerts")
    val alerts: Alerts,
    @Json(name = "arrival")
    val arrival: Arrival,
    @Json(name = "departure")
    val departure: Departure,
    @Json(name = "duration")
    val duration: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "vias")
    val vias: Vias
)
