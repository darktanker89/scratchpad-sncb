package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Departures(
    @Json(name = "departure")
    val departure: List<Departure>,
    @Json(name = "number")
    val number: Int
)
