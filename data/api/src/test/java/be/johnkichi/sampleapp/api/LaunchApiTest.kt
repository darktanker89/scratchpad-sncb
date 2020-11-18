package be.johnkichi.sampleapp.api

import be.johnkichi.sampleapp.api.base.BaseApiTest
import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.spacex.service.SpaceXService
import be.johnkichi.sampleapp.api.util.fromFile
import io.kotlintest.matchers.beInstanceOf
import io.kotlintest.should
import io.kotlintest.shouldBe
import java.io.IOException
import okhttp3.mockwebserver.MockResponse
import okhttp3.mockwebserver.SocketPolicy

// test response / surface parsing
internal class LaunchApiTest : BaseApiTest() {

    private val service: SpaceXService by lazy { retrofit.create(SpaceXService::class.java) }

    init {
        describe("Launch service") {
            context("One launch request") {
                server.enqueue(
                    MockResponse().fromFile("sampledata/one_launch.json")
                )
                val flightNumber = 65
                val response = service.getLaunch(flightNumber)

                it("Should return the requested launch successfully") {
                    (response is NetworkResponse.Success) shouldBe true
                }

                it("Should return the same launch as the sample data") {
                    (response as NetworkResponse.Success).body.flightNumber shouldBe flightNumber
                }
            }

            context("All launches request") {
                server.enqueue(
                    MockResponse().fromFile("sampledata/all_launches.json")
                )

                val response = service.getAllLaunches()

                it("Should return a list of launches") {
                    (response is NetworkResponse.Success) shouldBe true
                    (response as NetworkResponse.Success).body.size shouldBe 92
                }
            }
        }

        describe("Launch service - general error") {
            context("servor error occured") {
                server.enqueue(
                    MockResponse().fromFile("sampledata/error.json", 404)
                )

                val response = service.getAllLaunches()

                it("Should return an api error") {
                    (response is NetworkResponse.ApiError) shouldBe true
                }

                it("Should return the same error as the sample data") {
                    (response as NetworkResponse.ApiError).body.error shouldBe "some error occured"
                }

                it("Should return the right errorCode") {
                    (response as NetworkResponse.ApiError).code shouldBe 404
                }
            }
        }

        describe("Launcher service - no network") {
            context("no network error occured") {
                server.enqueue(
                    MockResponse().setSocketPolicy(SocketPolicy.DISCONNECT_AT_START)
                )

                val response = service.getAllLaunches()

                it("Should return an network error") {
                    (response is NetworkResponse.NetworkError) shouldBe true
                }

                it("Should return a network IOException") {
                    (response as NetworkResponse.NetworkError).error should beInstanceOf<IOException>()
                }
            }
        }
    }
}
