package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class SearchResult(
    @Json(name = "alternative")
    val alternative: List<Alternative>?,
    @Json(name = "avgStopTimes")
    val avgStopTimes: String,
    @Json(name = "country")
    val country: String,
    @Json(name = "@id")
    val id: String,
    @Json(name = "latitude")
    val latitude: String,
    @Json(name = "longitude")
    val longitude: String,
    @Json(name = "name")
    val name: String
)
