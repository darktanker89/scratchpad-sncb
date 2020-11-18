package be.johnkichi.sampleapp.api.rail.models.response

import androidx.annotation.Keep
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@Keep
@JsonClass(generateAdapter = true)
data class NonApiSearch(
    @Json(name = "@graph")
    val results: List<SearchResult>,
    @Json(name = "@id")
    val id: String
)
