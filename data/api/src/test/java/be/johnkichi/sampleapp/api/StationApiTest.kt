package be.johnkichi.sampleapp.api

import be.johnkichi.sampleapp.api.base.BaseApiTest
import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.rail.models.request.FieldFormat
import be.johnkichi.sampleapp.api.rail.models.request.FieldLang
import be.johnkichi.sampleapp.api.rail.service.IRailService
import be.johnkichi.sampleapp.api.util.fromFile
import io.kotlintest.shouldBe
import okhttp3.mockwebserver.MockResponse

internal class StationApiTest : BaseApiTest() {

    private val service: IRailService by lazy { retrofit.create(IRailService::class.java) }

    init {
        describe("Station Service") {
            context("all stations request") {
                server.enqueue(
                    MockResponse().fromFile("sampledata/all_stations.json")
                )
                val format = FieldFormat.JSON
                val language = FieldLang.EN

                val response = service.allStations(
                    format,
                    language
                )

                it("Should return the station successfully") {
                    (response is NetworkResponse.Success) shouldBe true
                }

                it("Should return the same station as the sample data") {
                    with((response as NetworkResponse.Success).body) {
                        version shouldBe "1.1"
                        timestamp shouldBe 1603280724
                        stations.size shouldBe 677
                    }
                }
            }
        }
    }
}
