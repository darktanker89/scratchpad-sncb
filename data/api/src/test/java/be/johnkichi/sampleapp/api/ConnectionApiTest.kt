package be.johnkichi.sampleapp.api

import be.johnkichi.sampleapp.api.base.BaseApiTest
import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.rail.service.IRailService
import be.johnkichi.sampleapp.api.util.fromFile
import io.kotlintest.matchers.collections.shouldNotBeEmpty
import io.kotlintest.matchers.types.shouldBeNull
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import okhttp3.mockwebserver.MockResponse

internal class ConnectionApiTest : BaseApiTest() {

    private val service: IRailService by lazy { retrofit.create(IRailService::class.java) }

    init {
        describe("Connection Service") {
            context("all connections requests") {
                server.enqueue(
                    MockResponse().fromFile("sampledata/connections.json")
                )
                val from = "Gent-Sint-Pieters"
                val to = "Mechelen"

                val response = service.connections(
                    from,
                    to
                )

                it("Should return the connections successfully") {
                    (response is NetworkResponse.Success) shouldBe true
                }

                it("Should return the same connections as the sample data") {
                    with((response as NetworkResponse.Success).body) {
                        version shouldBe "1.1"
                        timestamp shouldBe 1489622781
                        connection.isNullOrEmpty()
                        connection.size shouldBe 1
                        with(connection[0]) {
                            id shouldBe 0
                            departure.shouldNotBeNull()
                            with(departure) {
                                delay shouldBe 0
                                station.shouldNotBeNull()
                                station shouldBe "Antwerp-Central"
                                stationinfo.shouldNotBeNull()
                                with(stationinfo!!) {
                                    id shouldBe "BE.NMBS.008821006"
                                    atId shouldBe "http://irail.be/stations/NMBS/008821006"
                                    locationX shouldBe 4.421101
                                    locationY shouldBe 51.2172
                                    standardname shouldBe "Antwerpen-Centraal"
                                    name shouldBe "Antwerp-Central"
                                }
                                time shouldBe 1497783600
                                vehicle shouldBe "BE.NMBS.IC3033"
                                vehicleinfo.shouldNotBeNull()
                                with(vehicleinfo!!) {
                                    id shouldBe "http://irail.be/vehicle/IC3033"
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
                                left shouldBe 0
                                canceled shouldBe 0
                                direction.shouldNotBeNull()
                                with(direction!!) {
                                    name shouldBe "Mechelen"
                                }
                                stops.shouldNotBeNull()
                                with(stops!!) {
                                    number shouldBe 1
                                    stop.shouldNotBeNull()
                                    stop.shouldNotBeEmpty()
                                    stop.size shouldBe 1
                                    with(stop[0]) {
                                        id shouldBe 0
                                        station shouldBe "Antwerp-central"
                                        stationinfo.shouldNotBeNull()
                                        with(stationinfo) {
                                            id shouldBe "BE.NMBS.008821006"
                                            atId shouldBe "http://irail.be/stations/NMBS/008821006"
                                            locationX shouldBe 4.421101
                                            locationY shouldBe 51.2172
                                            standardname shouldBe "Antwerpen-Centraal"
                                            name shouldBe "Antwerp-Central"
                                        }
                                        time shouldBe 1489658760
                                        delay shouldBe 0
                                        canceled shouldBe 0
                                        departureDelay shouldBe 0
                                        departureCanceled shouldBe 0
                                        scheduledDepartureTime shouldBe 1489658760
                                        arrivalDelay shouldBe 0
                                        arrivalCanceled shouldBe 0
                                        isExtraStop shouldBe 0
                                        scheduledArrivalTime shouldBe 1489658760
                                        departureConnection shouldBe "http://irail.be/connections/8821006/20170316/IC3033"
                                    }
                                }
                                alerts.shouldNotBeNull()
                                with(alerts) {
                                    number shouldBe 1
                                    alert.shouldNotBeNull()
                                    alert.shouldNotBeEmpty()
                                    alert.size shouldBe 1
                                    with(alert[0]) {
                                        id shouldBe 0
                                        header shouldBe "L 50: We are conducting work for you between Ghent and Aalst."
                                        lead shouldBe "We are conducting work for you between Ghent and Aalst"
                                        link shouldBe "http%3A%2F%2Fwww.belgianrail.be%2Fjp%2Fdownload%2Fbrail_him%2F1509444366969_NL-11015.pdf"
                                        startTime shouldBe 1509441420
                                        endTime shouldBe 1510527540
                                    }
                                }
                                walking shouldBe 0
                                departureConnection shouldBe "http://irail.be/connections/8821006/20170316/IC1832"
                                occupancy.shouldBeNull()
                            }
                            arrival.shouldNotBeNull()
                            with(arrival) {
                                delay shouldBe 0
                                station.shouldNotBeNull()
                                station shouldBe "Antwerp-Central"
                                stationinfo.shouldNotBeNull()
                                with(stationinfo!!) {
                                    id shouldBe "BE.NMBS.008821006"
                                    atId shouldBe "http://irail.be/stations/NMBS/008821006"
                                    locationX shouldBe 4.421101
                                    locationY shouldBe 51.2172
                                    standardname shouldBe "Antwerpen-Centraal"
                                    name shouldBe "Antwerp-Central"
                                }
                                time shouldBe 1497786840
                                vehicle shouldBe "BE.NMBS.IC3033"
                                vehicleinfo.shouldNotBeNull()
                                with(vehicleinfo!!) {
                                    id shouldBe "http://irail.be/vehicle/IC3033"
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
                                arrived shouldBe 0
                                canceled shouldBe 0
                                walking shouldBe 0
                                direction.shouldNotBeNull()
                                with(direction) {
                                    name shouldBe "Mechelen"
                                }
                            }
                            duration shouldBe 3240
                            alerts.shouldNotBeNull()
                            with(alerts) {
                                number shouldBe 1
                                number shouldBe 1
                                alert.shouldNotBeNull()
                                alert.shouldNotBeEmpty()
                                alert.size shouldBe 1
                                with(alert[0]) {
                                    id shouldBe 0
                                    header shouldBe "L 50: We are conducting work for you between Ghent and Aalst."
                                    lead shouldBe "We are conducting work for you between Ghent and Aalst"
                                    link shouldBe "http%3A%2F%2Fwww.belgianrail.be%2Fjp%2Fdownload%2Fbrail_him%2F1509444366969_NL-11015.pdf"
                                    startTime shouldBe 1509441420
                                    endTime shouldBe 1510527540
                                }
                            }
                            vias.shouldNotBeNull()
                            with(vias) {
                                number shouldBe 1
                                via.shouldNotBeNull()
                                via.shouldNotBeEmpty()
                                via.size shouldBe 1
                                with(via[0]) {
                                    id shouldBe "Hello, world!"
                                    arrival.shouldNotBeNull()
                                    with(arrival) {
                                        stationinfo.shouldBeNull()
                                        time shouldBe 1497783600
                                        station.shouldBeNull()
                                        platform shouldBe 4
                                        platforminfo.shouldNotBeNull()
                                        with(platforminfo) {
                                            name shouldBe "4"
                                            normal shouldBe "1"
                                        }
                                        arrived shouldBe 0
                                        delay shouldBe 0
                                        canceled shouldBe 0
                                        vehicle shouldBe "BE.NMBS.IC3033"
                                        vehicleinfo.shouldBeNull()
                                        walking shouldBe 0
                                        direction.shouldNotBeNull()
                                        with(direction) {
                                            name shouldBe "Mechelen"
                                        }
                                    }
                                    departure.shouldNotBeNull()
                                    with(departure) {
                                        id.shouldBeNull()
                                        time shouldBe 1497783600
                                        platform shouldBe 4
                                        platforminfo.shouldNotBeNull()
                                        with(platforminfo) {
                                            name shouldBe "4"
                                            normal shouldBe "1"
                                        }
                                        station.shouldBeNull()
                                        stationinfo.shouldBeNull()
                                        left shouldBe 0
                                        delay shouldBe 0
                                        canceled shouldBe 0
                                        departureConnection shouldBe "http://irail.be/connections/8821006/20170316/IC1832"
                                        vehicle shouldBe "BE.NMBS.IC3033"
                                        walking shouldBe 0
                                        alerts.shouldNotBeNull()
                                        with(alerts) {
                                            number shouldBe 1
                                            alert.shouldNotBeNull()
                                            alert.shouldNotBeEmpty()
                                            alert.size shouldBe 1
                                            with(alert[0]) {
                                                id shouldBe 0
                                                header shouldBe "L 50: We are conducting work for you between Ghent and Aalst."
                                                lead shouldBe "We are conducting work for you between Ghent and Aalst"
                                                link shouldBe "http%3A%2F%2Fwww.belgianrail.be%2Fjp%2Fdownload%2Fbrail_him%2F1509444366969_NL-11015.pdf"
                                                startTime shouldBe 1509441420
                                                endTime shouldBe 1510527540
                                            }
                                        }
                                        direction.shouldNotBeNull()
                                        with(direction!!) {
                                            name shouldBe "Mechelen"
                                        }
                                        stops.shouldNotBeNull()
                                        with(stops!!) {
                                            number shouldBe 1
                                            stop.shouldNotBeNull()
                                            stop.shouldNotBeEmpty()
                                            stop.size shouldBe 1
                                            with(stop[0]) {
                                                id shouldBe 0
                                                station shouldBe "Antwerp-central"
                                                stationinfo.shouldNotBeNull()
                                                with(stationinfo) {
                                                    id shouldBe "BE.NMBS.008821006"
                                                    atId shouldBe "http://irail.be/stations/NMBS/008821006"
                                                    locationX shouldBe 4.421101
                                                    locationY shouldBe 51.2172
                                                    standardname shouldBe "Antwerpen-Centraal"
                                                    name shouldBe "Antwerp-Central"
                                                }
                                                time shouldBe 1489658760
                                                delay shouldBe 0
                                                platform.shouldBeNull()
                                                platforminfo.shouldBeNull()
                                                canceled shouldBe 0
                                                departureDelay shouldBe 0
                                                departureCanceled shouldBe 0
                                                scheduledDepartureTime shouldBe 1489658760
                                                arrivalDelay shouldBe 0
                                                arrivalCanceled shouldBe 0
                                                isExtraStop shouldBe 0
                                                scheduledArrivalTime shouldBe 1489658760
                                                departureConnection shouldBe "http://irail.be/connections/8821006/20170316/IC3033"
                                            }
                                        }
                                    }
                                    timeBetween shouldBe 360
                                    station shouldBe "Antwerp-Central"
                                    stationinfo.shouldNotBeNull()
                                    with(stationinfo) {
                                        id shouldBe "BE.NMBS.008821006"
                                        atId shouldBe "http://irail.be/stations/NMBS/008821006"
                                        locationX shouldBe 4.421101
                                        locationY shouldBe 51.2172
                                        standardname shouldBe "Antwerpen-Centraal"
                                        name shouldBe "Antwerp-Central"
                                    }
                                    vehicle shouldBe "BE.NMBS.IC3033"
                                    direction.shouldNotBeNull()
                                    with(direction) {
                                        name shouldBe "Mechelen"
                                    }
                                }
                            }
                        }
                    }
                }
            }
        }
    }
}
