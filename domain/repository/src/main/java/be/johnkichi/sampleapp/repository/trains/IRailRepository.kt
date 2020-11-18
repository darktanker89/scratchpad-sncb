package be.johnkichi.sampleapp.repository.trains

import be.johnkichi.sampleapp.models.Disturbance
import kotlinx.coroutines.flow.Flow

interface IRailRepository {
    fun disturbances(): Flow<List<Disturbance>>
    fun searchStation(station: String): Flow<List<String>>
    fun disturbance(id: String): Flow<Disturbance?>
}
