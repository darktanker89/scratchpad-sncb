package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Stationinfo(
    @Json(name = "id")
    val id: String,
    @Json(name = "@id")
    val atId: String,
    @Json(name = "locationX")
    val locationX: Double,
    @Json(name = "locationY")
    val locationY: Double,
    @Json(name = "name")
    val name: String,
    @Json(name = "standardname")
    val standardname: String
)
