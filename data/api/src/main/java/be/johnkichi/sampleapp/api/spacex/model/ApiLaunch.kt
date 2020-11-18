package be.johnkichi.sampleapp.api.spacex.model

import be.johnkichi.sampleapp.models.Launch
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass
import java.util.Date

@JsonClass(generateAdapter = true)
data class ApiLaunch(
    @Json(name = "flight_number") override val flightNumber: Int,
    @Json(name = "mission_name") override val missionName: String,
    @Json(name = "mission_id") override val missionId: List<String>,
    @Json(name = "launch_year") override val launchYear: String,
    @Json(name = "launch_date_utc") override val launchDate: Date,
    @Json(name = "is_tentative") override val isTentative: Boolean,
    @Json(name = "tentative_max_precision") override val tentativeMaxPrecision: String?,
    @Json(name = "tbd") override val tbd: Boolean,
    @Json(name = "launch_window") override val launchWindow: Int?,
    @Json(name = "ships") override val ships: List<String>,
    @Json(name = "launch_success") override val launchSuccess: Boolean?,
    @Json(name = "details") override val details: String?,
    @Json(name = "upcoming") override val upcoming: Boolean?,
    @Json(name = "static_fire_date_utc") override val staticFireDate: Date?
) : Launch
