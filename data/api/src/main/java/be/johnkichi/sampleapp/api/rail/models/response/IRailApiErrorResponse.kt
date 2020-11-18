package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class IRailApiErrorResponse(
    @Json(name = "error")
    val error: Int,
    @Json(name = "message")
    val message: String
)
