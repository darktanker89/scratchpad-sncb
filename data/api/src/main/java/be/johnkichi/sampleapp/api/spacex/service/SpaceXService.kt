package be.johnkichi.sampleapp.api.spacex.service

import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.spacex.model.ApiErrorResponse
import be.johnkichi.sampleapp.api.spacex.model.ApiLaunch
import retrofit2.http.GET
import retrofit2.http.Path

interface SpaceXService {
    @GET("v3/launches")
    suspend fun getAllLaunches(): NetworkResponse<List<ApiLaunch>, ApiErrorResponse>

    @GET("v3/launches/{flightNumber}")
    suspend fun getLaunch(@Path("flightNumber") flightNumber: Int): NetworkResponse<ApiLaunch, ApiErrorResponse>
}
