package be.johnkichi.sampleapp.api.rail.models.request

import com.squareup.moshi.Json

enum class FieldLang {
    @Json(name = "nl")
    NL,
    @Json(name = "fr")
    FR,
    @Json(name = "en")
    EN,
    @Json(name = "de")
    DE
}
