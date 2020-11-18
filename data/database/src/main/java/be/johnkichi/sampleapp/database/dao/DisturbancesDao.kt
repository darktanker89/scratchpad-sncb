package be.johnkichi.sampleapp.database.dao

import androidx.room.Dao
import androidx.room.Query
import be.johnkichi.sampleapp.database.entities.DbDisturbance

@Dao
abstract class DisturbancesDao : CrudDao<DbDisturbance> {
    @Query(
        """
        SELECT *
        FROM dbdisturbance
        WHERE id = :disturbanceId
    """
    )
    abstract suspend fun details(disturbanceId: String): DbDisturbance?

    @Query(
        """
        SELECT *
        FROM dbdisturbance
    """
    )
    abstract suspend fun all(): List<DbDisturbance>

    @Query(
        """
        DELETE FROM DbDisturbance
    """
    )
    abstract suspend fun clearTable()
}
