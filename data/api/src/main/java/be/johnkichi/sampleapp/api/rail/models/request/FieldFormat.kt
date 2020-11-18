package be.johnkichi.sampleapp.api.rail.models.request

import com.squareup.moshi.Json

enum class FieldFormat {
    @Json(name = "xml")
    XML,
    @Json(name = "json")
    JSON,
    @Json(name = "jsonp")
    JSONP,
}
