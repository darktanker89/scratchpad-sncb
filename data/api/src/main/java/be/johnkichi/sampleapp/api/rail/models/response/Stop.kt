package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Stop(
    @Json(name = "arrivalCanceled")
    val arrivalCanceled: Int,
    @Json(name = "arrivalDelay")
    val arrivalDelay: Int,
    @Json(name = "canceled")
    val canceled: Int,
    @Json(name = "delay")
    val delay: Int,
    @Json(name = "departureCanceled")
    val departureCanceled: Int,
    @Json(name = "departureConnection")
    val departureConnection: String,
    @Json(name = "departureDelay")
    val departureDelay: Int,
    @Json(name = "id")
    val id: Int,
    @Json(name = "isExtraStop")
    val isExtraStop: Int,
    @Json(name = "occupancy") // only in vehicle
    val occupancy: Occupancy?,
    @Json(name = "platform") // only in vehicle
    val platform: Int?,
    @Json(name = "platforminfo") // only in vehicle
    val platforminfo: Platforminfo?,
    @Json(name = "scheduledArrivalTime")
    val scheduledArrivalTime: Int,
    @Json(name = "scheduledDepartureTime")
    val scheduledDepartureTime: Int,
    @Json(name = "station")
    val station: String,
    @Json(name = "stationinfo")
    val stationinfo: Stationinfo,
    @Json(name = "time")
    val time: Int
)
