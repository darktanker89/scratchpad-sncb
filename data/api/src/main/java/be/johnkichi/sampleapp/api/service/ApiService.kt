package be.johnkichi.sampleapp.api.service

import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.spacex.model.Error
import be.johnkichi.sampleapp.api.spacex.model.Success
import retrofit2.http.GET

interface ApiService {
    @GET("success")
    suspend fun getSuccess(): NetworkResponse<Success, Error>

    @GET("error")
    suspend fun getError(): NetworkResponse<Success, Error>
}
