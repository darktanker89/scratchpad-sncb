package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Arrival(
    @Json(name = "arrived")
    val arrived: Int,
    @Json(name = "canceled")
    val canceled: Int,
    @Json(name = "delay")
    val delay: Int,
    @Json(name = "direction")
    val direction: Direction,
    @Json(name = "platform")
    val platform: Int,
    @Json(name = "platforminfo")
    val platforminfo: Platforminfo,
    @Json(name = "station") // only present in Connection.Arrival, no present in Connection.vias.via.arrival
    val station: String?,
    @Json(name = "stationinfo")
    val stationinfo: Stationinfo?, // present in Connection.arrival, not in Connection.vias.via.arrival
    @Json(name = "time")
    val time: Int,
    @Json(name = "vehicle")
    val vehicle: String,
    @Json(name = "vehicleinfo")
    val vehicleinfo: Vehicleinfo?, // present Connection.arrival, not in Connection.vias.via.arrival
    @Json(name = "walking")
    val walking: Int
)
