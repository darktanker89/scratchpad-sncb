package be.johnkichi.sampleapp.api.rail.mapper

import be.johnkichi.sampleapp.api.rail.models.response.ApiDisturbance
import be.johnkichi.sampleapp.models.Disturbance

fun ApiDisturbance.toDom(): Disturbance {
    return this
}
