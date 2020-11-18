package be.johnkichi.sampleapp.api.spacex.mapper

import be.johnkichi.sampleapp.api.spacex.model.ApiLaunch
import be.johnkichi.sampleapp.models.Launch

fun ApiLaunch.toDom(): Launch {
    return this
}
