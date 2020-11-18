package be.johnkichi.sampleapp.database.mapper

import be.johnkichi.sampleapp.database.entities.DbLaunch
import be.johnkichi.sampleapp.models.Launch

fun DbLaunch.toDom(): Launch {
    return this
}

fun Launch.toDbLaunch(): DbLaunch {
    return DbLaunch(
        flightNumber,
        missionName,
        missionId,
        launchYear,
        launchDate,
        isTentative,
        tentativeMaxPrecision,
        tbd,
        launchWindow,
        ships,
        launchSuccess,
        details,
        upcoming,
        staticFireDate
    )
}
