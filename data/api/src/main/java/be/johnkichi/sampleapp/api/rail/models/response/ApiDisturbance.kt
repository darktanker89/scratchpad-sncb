package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import be.johnkichi.sampleapp.models.Disturbance
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class ApiDisturbance(
    @Json(name = "attachment")
    override val attachment: String?,
    @Json(name = "description")
    override val description: String,
    @Json(name = "id")
    override val id: String,
    @Json(name = "link")
    override val link: String,
    @Json(name = "timestamp")
    override val timestamp: String,
    @Json(name = "title")
    override val title: String,
    @Json(name = "type")
    override val type: String
) : Disturbance
