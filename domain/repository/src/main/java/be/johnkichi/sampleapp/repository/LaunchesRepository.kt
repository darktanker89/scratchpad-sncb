package be.johnkichi.sampleapp.repository

import android.util.Log
import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.base.executeWithRetry
import be.johnkichi.sampleapp.api.spacex.mapper.toDom
import be.johnkichi.sampleapp.api.spacex.service.SpaceXService
import be.johnkichi.sampleapp.database.dao.LaunchDao
import be.johnkichi.sampleapp.database.entities.DbLaunch
import be.johnkichi.sampleapp.database.mapper.toDbLaunch
import be.johnkichi.sampleapp.database.mapper.toDom
import be.johnkichi.sampleapp.models.Launch
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class LaunchesRepository @Inject constructor(
    private val launchDao: LaunchDao,
    private val spaceXService: SpaceXService
) : ILaunchRepository {
    override fun getAllLaunches(): Flow<List<Launch>> = flow {
        var all: List<DbLaunch> = getCachedLaunches()

        if (all.isNullOrEmpty()) {
            when (val response = getApiLaunches()) {
                is NetworkResponse.Success -> {
                    Log.d("FGV", "Success ${response.body}")
                    val res = response.body.map { it.toDom().toDbLaunch() }
                    launchDao.saveAll(res)
                }
                is NetworkResponse.ApiError -> Log.d("FGV", "ApiError ${response.body}")
                is NetworkResponse.NetworkError -> Log.d("FGV", "NetworkError")
                is NetworkResponse.UnknownError -> Log.d("FGV", "UnknownError")
            }
        }

        all = getCachedLaunches()

        emit(
            all.map {
                dbLaunch ->
                dbLaunch.toDom()
            }
        )
    }

    private suspend fun getCachedLaunches() = withContext(Dispatchers.IO) {
        launchDao.all()
    }

    private suspend fun getApiLaunches() = withContext(Dispatchers.IO) {
        executeWithRetry {
            spaceXService.getAllLaunches()
        }
    }
}
