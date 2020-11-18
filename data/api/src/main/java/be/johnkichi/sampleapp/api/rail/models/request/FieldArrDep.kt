package be.johnkichi.sampleapp.api.rail.models.request

import com.squareup.moshi.Json

enum class FieldArrDep {
    @Json(name = "departure")
    DEPARTURE,
    @Json(name = "arrival")
    ARRIVAL
}
