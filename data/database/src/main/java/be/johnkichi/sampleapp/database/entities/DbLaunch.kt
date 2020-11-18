package be.johnkichi.sampleapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import be.johnkichi.sampleapp.models.Launch
import java.util.Date

@Entity
data class DbLaunch(
    @PrimaryKey
    @ColumnInfo(name = "flight_number")
    override val flightNumber: Int,
    @ColumnInfo(name = "mission_name")
    override val missionName: String,
    @ColumnInfo(name = "mission_id")
    override val missionId: List<String>,
    @ColumnInfo(name = "launch_year")
    override val launchYear: String,
    @ColumnInfo(name = "launch_date_utc")
    override val launchDate: Date,
    @ColumnInfo(name = "is_tentative")
    override val isTentative: Boolean,
    @ColumnInfo(name = "tentative_max_precision")
    override val tentativeMaxPrecision: String?,
    @ColumnInfo(name = "tbd")
    override val tbd: Boolean,
    @ColumnInfo(name = "launch_window")
    override val launchWindow: Int?,
    @ColumnInfo(name = "ships")
    override val ships: List<String>,
    @ColumnInfo(name = "launch_success")
    override val launchSuccess: Boolean?,
    @ColumnInfo(name = "details")
    override val details: String?,
    @ColumnInfo(name = "upcoming")
    override val upcoming: Boolean?,
    @ColumnInfo(name = "static_fire_date_utc")
    override val staticFireDate: Date?
) : Launch
