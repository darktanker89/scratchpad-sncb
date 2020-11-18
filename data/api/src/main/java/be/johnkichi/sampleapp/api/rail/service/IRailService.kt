package be.johnkichi.sampleapp.api.rail.service

import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.rail.models.request.FieldArrDep
import be.johnkichi.sampleapp.api.rail.models.request.FieldFormat
import be.johnkichi.sampleapp.api.rail.models.request.FieldLang
import be.johnkichi.sampleapp.api.rail.models.request.FieldTypeOfTransport
import be.johnkichi.sampleapp.api.rail.models.request.OccupancyReport
import be.johnkichi.sampleapp.api.rail.models.response.BlankResponse
import be.johnkichi.sampleapp.api.rail.models.response.ConnectionsResponse
import be.johnkichi.sampleapp.api.rail.models.response.DisturbancesResponse
import be.johnkichi.sampleapp.api.rail.models.response.IRailApiErrorResponse
import be.johnkichi.sampleapp.api.rail.models.response.LiveBoardResponse
import be.johnkichi.sampleapp.api.rail.models.response.NonApiSearch
import be.johnkichi.sampleapp.api.rail.models.response.StationsResponse
import be.johnkichi.sampleapp.api.rail.models.response.VehicleResponse
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.POST
import retrofit2.http.Query
import retrofit2.http.Url

interface IRailService {
    @GET("stations")
    suspend fun allStations(
        @Query("format") format: FieldFormat = FieldFormat.JSON,
        @Query("lang") lang: FieldLang = FieldLang.EN,
    ): NetworkResponse<StationsResponse, IRailApiErrorResponse>

    @GET("liveboard")
    suspend fun liveboard(
        @Query("station") station: String? = null,
        @Query("id") id: String? = null,
        @Query("arrdep") arrdep: FieldArrDep = FieldArrDep.DEPARTURE,
        @Query("alerts") alert: Boolean? = null,
        @Query("time") time: String? = null, // ? tz?
        @Query("date") date: String? = null, // dateformater iso?
        @Query("format") format: FieldFormat = FieldFormat.JSON,
        @Query("lang") lang: FieldLang = FieldLang.EN,
    ): NetworkResponse<LiveBoardResponse, IRailApiErrorResponse>

    @GET("connections")
    suspend fun connections(
        @Query("from") from: String,
        @Query("to") to: String,
        @Query("timesel") timesel: FieldArrDep = FieldArrDep.DEPARTURE,
        @Query("typeOfTransport") typeOfTransport: FieldTypeOfTransport = FieldTypeOfTransport.AUTOMATIC,
        @Query("alerts") alert: Boolean? = null,
        // @Query("results") results: Int? = null,
        @Query("time") time: String? = null, // ? 1230 - hhmm
        @Query("date") date: String? = null, // 300920 - ddmmyy
        @Query("format") format: FieldFormat = FieldFormat.JSON,
        @Query("lang") lang: FieldLang = FieldLang.EN,
    ): NetworkResponse<ConnectionsResponse, IRailApiErrorResponse>

    @GET("vehicle")
    suspend fun vehicle(
        @Query("id") id: String, // BE.NMBS.IC1832
        @Query("date") date: String? = null, // 300920 - ddmmyy
        @Query("alerts") alert: Boolean? = true,
        @Query("format") format: FieldFormat = FieldFormat.JSON,
        @Query("lang") lang: FieldLang = FieldLang.EN,
    ): NetworkResponse<VehicleResponse, IRailApiErrorResponse>

    @GET("disturbances")
    suspend fun disturbances(
        @Query("lineBreakCharacter") lineBreak: String = "",
        @Query("format") format: FieldFormat = FieldFormat.JSON,
        @Query("lang") lang: FieldLang = FieldLang.EN,
    ): NetworkResponse<DisturbancesResponse, IRailApiErrorResponse>

    @POST("feedback/occupancy")
    suspend fun feedbackOccupancy(
        @Body occupancyReport: OccupancyReport
    ): NetworkResponse<BlankResponse, IRailApiErrorResponse>

    @Headers("Accept: application/json")
    @GET
    suspend fun search(
        @Url url: String = "https://irail.be/stations/NMBS",
        @Query("q") place: String
    ): NetworkResponse<NonApiSearch, IRailApiErrorResponse>
}
