package be.johnkichi.sampleapp.api.rail.models.request

import com.squareup.moshi.Json

enum class FieldTypeOfTransport {
    @Json(name = "automatic")
    AUTOMATIC,
    @Json(name = "trains")
    TRAIN,
    @Json(name = "nointernationaltrains")
    NO_INTERNATIONAL_TRAINS,
    @Json(name = "all")
    ALL
}
