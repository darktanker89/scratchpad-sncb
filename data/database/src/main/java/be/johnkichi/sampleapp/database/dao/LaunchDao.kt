package be.johnkichi.sampleapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import be.johnkichi.sampleapp.database.entities.DbLaunch

@Dao
abstract class LaunchDao : CrudDao<DbLaunch> {

    @Query(
        """
        SELECT *
        FROM dblaunch
        WHERE flight_number = :flightNumber
        """
    )
    abstract suspend fun details(flightNumber: Int): DbLaunch?

    @Query(
        """
        SELECT *
        FROM dblaunch
    """
    )
    abstract suspend fun all(): List<DbLaunch>

    @Query(
        """
        DELETE FROM dblaunch
    """
    )
    abstract suspend fun clearTable()
}
