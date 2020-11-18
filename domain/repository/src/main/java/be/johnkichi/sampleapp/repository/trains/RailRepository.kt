package be.johnkichi.sampleapp.repository.trains

import android.util.Log
import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.base.executeWithRetry
import be.johnkichi.sampleapp.api.rail.mapper.toDom
import be.johnkichi.sampleapp.api.rail.service.IRailService
import be.johnkichi.sampleapp.database.dao.DisturbancesDao
import be.johnkichi.sampleapp.database.mapper.toDbDisturbance
import be.johnkichi.sampleapp.models.Disturbance
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.withContext
import javax.inject.Inject

class RailRepository @Inject constructor(
    private val disturbancesDao: DisturbancesDao,
    private val railService: IRailService
) : IRailRepository {
    override fun disturbances(): Flow<List<Disturbance>> = flow {
        // preemptive clear
        // disturbancesDao.clearTable()
        var disturbances = getCachedDisturbances()

        if (disturbances.isNullOrEmpty()) {
            when (val response = getApiDisturbances()) {
                is NetworkResponse.Success -> {
                    Log.d("FGV", "Success ${response.body} ")
                    val _disturbances = response.body.disturbance.map { it.toDom() }
                    disturbancesDao.saveAll(_disturbances.map { it.toDbDisturbance() })
                }
                is NetworkResponse.ApiError -> Log.d("FGV", "ApiError ${response.body}")
                is NetworkResponse.NetworkError -> Log.d("FGV", "NetworkError")
                is NetworkResponse.UnknownError -> Log.d("FGV", "UnknownError")
            }
        }

        disturbances = getCachedDisturbances()

        emit(disturbances)
    }

    override fun searchStation(station: String): Flow<List<String>> = flow {
        val results = mutableListOf<String>()
        when (val response = railService.search(place = station)) {
            is NetworkResponse.Success -> {
                Log.d("FGV", "Success ${response.body} ")
                results.addAll(response.body.results.map { it.name })
            }
            is NetworkResponse.ApiError -> Log.d("FGV", "ApiError ${response.body}")
            is NetworkResponse.NetworkError -> Log.d("FGV", "NetworkError")
            is NetworkResponse.UnknownError -> Log.d("FGV", "UnknownError")
        }
        emit(results)
    }

    override fun disturbance(id: String): Flow<Disturbance?> = flow {
        emit(disturbancesDao.details(id))
    }

    private suspend fun getCachedDisturbances() = withContext(Dispatchers.IO) {
        disturbancesDao.all()
    }

    private suspend fun getApiDisturbances() = withContext(Dispatchers.IO) {
        executeWithRetry {
            railService.disturbances()
        }
    }
}
