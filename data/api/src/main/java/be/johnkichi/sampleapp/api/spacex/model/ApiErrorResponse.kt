package be.johnkichi.sampleapp.api.spacex.model

import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiErrorResponse(
    @Json(name = "error") val error: String
)
