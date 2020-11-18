package be.johnkichi.sampleapp.api

import be.johnkichi.sampleapp.api.base.BaseApiTest
import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.rail.models.request.FieldArrDep
import be.johnkichi.sampleapp.api.rail.models.request.FieldFormat
import be.johnkichi.sampleapp.api.rail.models.request.FieldLang
import be.johnkichi.sampleapp.api.rail.service.IRailService
import be.johnkichi.sampleapp.api.util.fromFile
import io.kotlintest.matchers.types.shouldBeNull
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import okhttp3.mockwebserver.MockResponse

internal class LiveboardApiTest : BaseApiTest() {

    private val service: IRailService by lazy { retrofit.create(IRailService::class.java) }

    init {
        describe("Liveboard Service") {
            context("liveboard request") {
                server.enqueue(
                    MockResponse().fromFile("sampledata/liveboard.json")
                )
                val station = "Gent-Sint-Pieters" // mutually exclusiv
                val id: String? = "BE.NMBS.008892007" // mutually exclusiv
                val arrdep = FieldArrDep.DEPARTURE
                val alert: Boolean? = true
                val time: String? = "1230" // ? tz?
                val date: String? = "300917" // dateformater iso?
                val format: FieldFormat = FieldFormat.JSON
                val lang: FieldLang = FieldLang.EN

                val response = service.liveboard(
                    station,
                    id,
                    arrdep,
                    alert,
                    time,
                    date,
                    format,
                    lang
                )

                it("Should return the liveboard successfully") {
                    (response is NetworkResponse.Success) shouldBe true
                }

                it("Should return the same liveboard as the sample data") {
                    with((response as NetworkResponse.Success).body) {
                        version shouldBe "1.1"
                        timestamp shouldBe 1489614297
                        this.station.shouldNotBeNull()
                        this.station shouldBe "Ghent-Sint-Pieters"
                        stationinfo.shouldNotBeNull()
                        with(stationinfo) {
                            this.id shouldBe "BE.NMBS.008821006"
                            atId shouldBe "http://irail.be/stations/NMBS/008821006"
                            locationX shouldBe 4.421101
                            locationY shouldBe 51.2172
                            standardname shouldBe "Antwerpen-Centraal"
                            name shouldBe "Antwerp-Central"
                        }
                        departures.shouldNotBeNull()
                        with(departures) {
                            number shouldBe 32
                            departure.shouldNotBeNull()
                            departure.size shouldBe 1
                            with(departure[0]) {
                                this.id.shouldNotBeNull()
                                this.id shouldBe 0
                                delay shouldBe 0
                                direction.shouldBeNull()
                                this.station shouldBe "Antwerp-Central"
                                stationinfo.shouldNotBeNull()
                                with(this.stationinfo!!) {
                                    this.id shouldBe "BE.NMBS.008821006"
                                    atId shouldBe "http://irail.be/stations/NMBS/008821006"
                                    locationX shouldBe 4.421101
                                    locationY shouldBe 51.2172
                                    standardname shouldBe "Antwerpen-Centraal"
                                    name shouldBe "Antwerp-Central"
                                }
                                this.time shouldBe 1489575600
                                vehicle shouldBe "BE.NMBS.IC3033"
                                vehicleinfo.shouldNotBeNull()
                                with(vehicleinfo!!) {
                                    this.id shouldBe "http://irail.be/vehicle/IC3033"
                                    locationX.shouldBeNull()
                                    locationY.shouldBeNull()
                                    name shouldBe "BE.NMBS.IC3033"
                                    shortname shouldBe "IC3033"
                                }
                                platform shouldBe 4
                                platforminfo.shouldNotBeNull()
                                with(platforminfo) {
                                    name shouldBe "4"
                                    normal shouldBe "1"
                                }
                                canceled shouldBe 0
                                left shouldBe 0
                                departureConnection shouldBe "http://irail.be/connections/8821006/20170316/IC1832"
                                occupancy.shouldNotBeNull()
                                with(occupancy!!) {
                                    this.id shouldBe "http://api.irail.be/terms/unknown"
                                    name shouldBe "unknown"
                                }
                                stops.shouldBeNull()
                                walking.shouldBeNull()
                            }
                        }
                    }
                }
            }
        }
    }
}
