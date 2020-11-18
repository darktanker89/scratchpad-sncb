package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class VehicleResponse(
    @Json(name = "stops")
    val stops: Stops,
    @Json(name = "timestamp")
    val timestamp: Int,
    @Json(name = "vehicle")
    val vehicle: String,
    @Json(name = "vehicleinfo")
    val vehicleinfo: Vehicleinfo,
    @Json(name = "version")
    val version: String
)
