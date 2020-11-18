package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Vehicleinfo(
    @Json(name = "@id")
    val id: String,
    @Json(name = "locationX") // only used in vehicle
    val locationX: Double?,
    @Json(name = "locationY")
    val locationY: Double?, // only used in vehicle
    @Json(name = "name")
    val name: String,
    @Json(name = "shortname")
    val shortname: String
)
