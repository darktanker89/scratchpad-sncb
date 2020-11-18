package be.johnkichi.sampleapp.repository

import be.johnkichi.sampleapp.models.Launch
import kotlinx.coroutines.flow.Flow

interface ILaunchRepository {
    fun getAllLaunches(): Flow<List<Launch>>
}
