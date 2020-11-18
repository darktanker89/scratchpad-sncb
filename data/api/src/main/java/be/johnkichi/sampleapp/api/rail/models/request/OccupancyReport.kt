package be.johnkichi.sampleapp.api.rail.models.request

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class OccupancyReport(
    @Json(name = "connection")
    val connection: String,
    @Json(name = "date")
    val date: String,
    @Json(name = "from")
    val from: String,
    @Json(name = "occupancy")
    val occupancy: FieldOccupancy,
    @Json(name = "vehicle")
    val vehicle: String
)
