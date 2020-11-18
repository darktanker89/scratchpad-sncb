package be.johnkichi.sampleapp.api

import be.johnkichi.sampleapp.api.rail.models.response.StationsResponse
import be.johnkichi.sampleapp.api.util.useJSON
import be.johnkichi.sampleapp.api.util.useJSONAdapter
import io.kotlintest.assertSoftly
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import io.kotlintest.specs.AnnotationSpec

internal class StationParsingTest : AnnotationSpec() {

    @Test
    fun testStationApiParsing() {
        val stationsJson = useJSON("sampledata/all_stations.json")
        val jsonAdapter = useJSONAdapter<StationsResponse>()
        val station = jsonAdapter.fromJson(stationsJson)

        assertSoftly {
            with(station) {
                this.shouldNotBeNull()
                version shouldBe "1.1"
                timestamp shouldBe 1603280724
                stations.size shouldBe 677
            }

            with(station!!.stations[0]) {
                id shouldBe "BE.NMBS.000000101"
                atId shouldBe "http://irail.be/stations/NMBS/000000101"
                locationX shouldBe 4.32571361
                locationY shouldBe 51.2191923
                name shouldBe "Zwijndrecht Dorp"
                standardname shouldBe "Zwijndrecht Dorp"
            }
        }
    }
}
