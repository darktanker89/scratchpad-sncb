package be.johnkichi.sampleapp.api

import be.johnkichi.sampleapp.api.base.BaseApiTest
import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.rail.models.request.FieldFormat
import be.johnkichi.sampleapp.api.rail.models.request.FieldLang
import be.johnkichi.sampleapp.api.rail.service.IRailService
import be.johnkichi.sampleapp.api.util.fromFile
import io.kotlintest.matchers.collections.shouldNotBeEmpty
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import okhttp3.mockwebserver.MockResponse

internal class VehicleApiTest : BaseApiTest() {

    private val service: IRailService by lazy { retrofit.create(IRailService::class.java) }

    init {
        describe("Liveboard Service") {
            context("liveboard request") {
                server.enqueue(
                    MockResponse().fromFile("sampledata/vehicle.json")
                )
            }

            val id = "BE.NMBS.IC1832"
            val date = "300917"
            val format: FieldFormat = FieldFormat.JSON
            val lang: FieldLang = FieldLang.EN

            val response = service.vehicle(
                id = id,
                date = date,
                format = format,
                lang = lang
            )

            it("Should return the vehicle successfully") {
                (response is NetworkResponse.Success) shouldBe true
            }

            it("Should return the same vehicle as the sample data") {
                with((response as NetworkResponse.Success).body) {
                    version shouldBe "1.1"
                    timestamp shouldBe 1489621902
                    vehicle shouldBe "BE.NMBS.IC3033"
                    vehicleinfo.shouldNotBeNull()
                    with(vehicleinfo) {
                        name shouldBe "BE.NMBS.IC3033"
                        locationX shouldBe 4.421101
                        locationY shouldBe 51.2172
                        shortname shouldBe "IC3033"
                        this.id shouldBe "http://irail.be/vehicle/IC3033"
                    }
                    stops.shouldNotBeNull()
                    with(stops) {
                        number shouldBe 10
                        stop.shouldNotBeNull()
                        stop.shouldNotBeEmpty()
                        stop.size shouldBe 1
                        with(stop[0]) {
                            this.id shouldBe 0
                            station shouldBe "Antwerp-central"
                            stationinfo.shouldNotBeNull()
                            with(stationinfo) {
                                this.id shouldBe "BE.NMBS.008821006"
                                atId shouldBe "http://irail.be/stations/NMBS/008821006"
                                locationX shouldBe 4.421101
                                locationY shouldBe 51.2172
                                standardname shouldBe "Antwerpen-Centraal"
                                name shouldBe "Antwerp-Central"
                            }
                            time shouldBe 1489658760
                            delay shouldBe 0
                            platform.shouldNotBeNull()
                            platform shouldBe 4
                            platforminfo.shouldNotBeNull()
                            with(platforminfo!!) {
                                name shouldBe "4"
                                normal shouldBe "1"
                            }
                            canceled shouldBe 0
                            departureDelay shouldBe 0
                            scheduledDepartureTime shouldBe 1489658760
                            arrivalDelay shouldBe 0
                            arrivalCanceled shouldBe 0
                            isExtraStop shouldBe 0
                            scheduledArrivalTime shouldBe 1489658760
                            departureConnection shouldBe "http://irail.be/connections/8821006/20170316/IC3033"
                            occupancy.shouldNotBeNull()
                            with(occupancy!!) {
                                this.id shouldBe "http://api.irail.be/terms/unknown"
                                name shouldBe "unknown"
                            }
                        }
                    }
                }
            }
        }
    }
}
