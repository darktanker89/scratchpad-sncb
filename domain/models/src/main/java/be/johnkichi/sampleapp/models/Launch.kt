package be.johnkichi.sampleapp.models

import java.util.Date

interface Launch {
    val flightNumber: Int
    val missionName: String
    val missionId: List<String>
    val launchYear: String
    val launchDate: Date
    val isTentative: Boolean
    val tentativeMaxPrecision: String?
    val tbd: Boolean
    val launchWindow: Int?
    val ships: List<String>
    val launchSuccess: Boolean?
    val details: String?
    val upcoming: Boolean?
    val staticFireDate: Date?
}
