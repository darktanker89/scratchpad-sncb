package be.johnkichi.sampleapp.models

open class Rocket(
    open val id: Int,
    open val active: Boolean,
    open val stages: Int,
    open val boosters: Int,
    open val costPerLaunch: Long,
    open val successRate: Double,
    open val firstFlight: String,
    open val country: String,
    open val company: String,
    open val wikipedia: String,
    open val description: String,
    open val rocketId: String,
    open val rocketName: String,
    open val rocketType: String
)
