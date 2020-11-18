package be.johnkichi.sampleapp.api.spacex.mapper

import be.johnkichi.sampleapp.api.spacex.model.ApiRocket
import be.johnkichi.sampleapp.models.Rocket

fun ApiRocket.toDom(): Rocket {
    return this
}
