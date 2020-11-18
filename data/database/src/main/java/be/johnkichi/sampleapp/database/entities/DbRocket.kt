package be.johnkichi.sampleapp.database.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import be.johnkichi.sampleapp.models.Rocket

@Entity
data class DbRocket(
    @PrimaryKey
    @ColumnInfo(name = "id")
    override val id: Int,
    @ColumnInfo(name = "active")
    override val active: Boolean,
    @ColumnInfo(name = "stages")
    override val stages: Int,
    @ColumnInfo(name = "boosters")
    override val boosters: Int,
    @ColumnInfo(name = "cost_per_launch")
    override val costPerLaunch: Long,
    @ColumnInfo(name = "success_rate_pct")
    val successRatePercentage: Double,
    @ColumnInfo(name = "first_flight")
    override val firstFlight: String,
    @ColumnInfo(name = "country")
    override val country: String,
    @ColumnInfo(name = "company")
    override val company: String,
    @ColumnInfo(name = "wikipedia")
    override val wikipedia: String,
    @ColumnInfo(name = "description")
    override val description: String,
    @ColumnInfo(name = "rocket_name")
    override val rocketName: String,
    @ColumnInfo(name = "rocket_type")
    override val rocketType: String,
    @ColumnInfo(name = "rocket_id")
    override val rocketId: String
) : Rocket(
    id,
    active,
    stages,
    boosters,
    costPerLaunch,
    successRatePercentage,
    firstFlight,
    country,
    company,
    wikipedia,
    description,
    rocketId,
    rocketName,
    rocketType
)
