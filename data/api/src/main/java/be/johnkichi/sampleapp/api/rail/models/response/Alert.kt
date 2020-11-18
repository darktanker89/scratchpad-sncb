package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class Alert(
    @Json(name = "endTime")
    val endTime: Int,
    @Json(name = "header")
    val header: String,
    @Json(name = "id")
    val id: Int,
    @Json(name = "lead")
    val lead: String,
    @Json(name = "link")
    val link: String,
    @Json(name = "startTime")
    val startTime: Int
)
