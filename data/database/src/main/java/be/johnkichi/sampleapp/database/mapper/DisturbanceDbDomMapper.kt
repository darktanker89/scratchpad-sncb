package be.johnkichi.sampleapp.database.mapper

import be.johnkichi.sampleapp.database.entities.DbDisturbance
import be.johnkichi.sampleapp.models.Disturbance

fun DbDisturbance.toDom(): Disturbance {
    return this
}

fun Disturbance.toDbDisturbance(): DbDisturbance {
    return DbDisturbance(
        id,
        attachment,
        description,
        link,
        timestamp,
        title,
        type
    )
}
