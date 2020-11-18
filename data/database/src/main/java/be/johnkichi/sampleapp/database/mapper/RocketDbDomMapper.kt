package be.johnkichi.sampleapp.database.mapper

import be.johnkichi.sampleapp.database.entities.DbRocket
import be.johnkichi.sampleapp.models.Rocket

fun DbRocket.toDom(): Rocket {
    return this
}

fun Rocket.toDbRocket(): DbRocket {
    return DbRocket(
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
}
