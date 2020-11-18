package be.johnkichi.sampleapp.database

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import be.johnkichi.sampleapp.database.converter.Converters
import be.johnkichi.sampleapp.database.dao.DisturbancesDao
import be.johnkichi.sampleapp.database.dao.LaunchDao
import be.johnkichi.sampleapp.database.entities.DbDisturbance
import be.johnkichi.sampleapp.database.entities.DbLaunch

@Database(
    entities = [
        DbLaunch::class,
        DbDisturbance::class
    ],
    version = 1,
    exportSchema = false
)
@TypeConverters(Converters::class)
abstract class AppDb : RoomDatabase() {
    abstract fun launchDao(): LaunchDao
    abstract fun disturbanceDao(): DisturbancesDao
}
