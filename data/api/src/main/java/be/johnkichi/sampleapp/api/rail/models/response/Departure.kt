package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Departure(
    @Json(name = "canceled")
    val canceled: Int,
    @Json(name = "direction") // present in connection.departure/connection.departure.vias.via.departure // , no direction in liveboard.departures.departure
    val direction: Direction?,
    @Json(name = "delay")
    val delay: Int,
    @Json(name = "departureConnection")
    val departureConnection: String,
    @Json(name = "id")
    val id: Int?, // Inconsistency: only on liveboard, null in connection departure
    @Json(name = "left")
    val left: Int,
    @Json(name = "occupancy")
    val occupancy: Occupancy?,
    @Json(name = "platform")
    val platform: Int,
    @Json(name = "platforminfo")
    val platforminfo: Platforminfo,
    @Json(name = "station") // present in liveboard departures.departure, not present in connections.vias.via.departure
    val station: String?,
    @Json(name = "stationinfo") // present in liveboard.departures.departure, not present in connections.vias.via.departure
    val stationinfo: Stationinfo?,
    @Json(name = "stops") // present in connection.departure  ,null in liveboard.departures.departure
    val stops: Stops?,
    @Json(name = "time")
    val time: Int,
    @Json(name = "vehicle")
    val vehicle: String,
    @Json(name = "vehicleinfo") // present in liveboard.departure & connection.departure, null in connection.vias.via.departure
    val vehicleinfo: Vehicleinfo?,
    @Json(name = "walking") // null in liveboard.departures.departure
    val walking: Int?
)
