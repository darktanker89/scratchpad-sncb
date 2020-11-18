package be.johnkichi.sampleapp.api.spacex.model

import be.johnkichi.sampleapp.models.Rocket
import com.squareup.moshi.Json
import com.squareup.moshi.JsonClass

@JsonClass(generateAdapter = true)
data class ApiRocket(
    @Json(name = "id") override val id: Int,
    @Json(name = "active") override val active: Boolean,
    @Json(name = "stages") override val stages: Int,
    @Json(name = "boosters") override val boosters: Int,
    @Json(name = "cost_per_launch") override val costPerLaunch: Long,
    @Json(name = "success_rate_pct") override val successRate: Double,
    @Json(name = "first_flight") override val firstFlight: String,
    @Json(name = "country") override val country: String,
    @Json(name = "company") override val company: String,
    @Json(name = "wikipedia") override val wikipedia: String,
    @Json(name = "description") override val description: String,
    @Json(name = "rocket_id") override val rocketId: String,
    @Json(name = "rocket_name") override val rocketName: String,
    @Json(name = "rocket_type") override val rocketType: String
) : Rocket(
    id,
    active,
    stages,
    boosters,
    costPerLaunch,
    successRate,
    firstFlight,
    country,
    company,
    wikipedia,
    description,
    rocketId,
    rocketName,
    rocketType
)
