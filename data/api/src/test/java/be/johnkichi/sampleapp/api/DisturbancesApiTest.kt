package be.johnkichi.sampleapp.api

import be.johnkichi.sampleapp.api.base.BaseApiTest
import be.johnkichi.sampleapp.api.base.NetworkResponse
import be.johnkichi.sampleapp.api.rail.service.IRailService
import be.johnkichi.sampleapp.api.util.fromFile
import io.kotlintest.matchers.types.shouldBeNull
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import okhttp3.mockwebserver.MockResponse

internal class DisturbancesApiTest : BaseApiTest() {

    private val service: IRailService by lazy { retrofit.create(IRailService::class.java) }

    init {
        describe("Disturbances Service") {
            context("disturbances request") {
                server.enqueue(
                    MockResponse().fromFile("sampledata/disturbances.json")
                )
            }

            val response = service.disturbances()

            it("Should return the disturbances successfully") {
                (response is NetworkResponse.Success) shouldBe true
            }

            it("Should return the same disturbances as the sample data") {
                with((response as NetworkResponse.Success).body) {
                    version shouldBe "1.1"
                    timestamp shouldBe "1581853952"
                    disturbance.shouldNotBeNull()
                    disturbance.size shouldBe 5
                    with(disturbance[0]) {
                        id shouldBe "0"
                        title shouldBe "Brux.-Midi/Brus.-Zuid - Amsterdam CS (NL): Incident on the Dutch rail network."
                        description shouldBe "Between Brux.-Midi/Brus.-Zuid and Amsterdam CS (NL): Delays and cancellations are possible." +
                            "Between Rotterdam CS (NL) and Amsterdam CS (NL): Disrupted train traffic. Indefinite duration of the failure." +
                            " Listen to the announcements, consult the automatic departure boards or plan your trip" +
                            " via the SNCB app or sncb.be for more information."
                        link shouldBe "http://www.belgianrail.be/jp/nmbs-realtime/help.exe/en?tpl=showmap_external&tplParamHimMsgInfoGroup=trouble&" +
                            "messageID=41188&channelFilter=custom2,livemap,rss_line_10,twitter,custom1,timetable&"
                        type shouldBe "disturbance"
                        timestamp shouldBe "1581853724"
                        attachment.shouldBeNull()
                    }
                    with(disturbance[4]) {
                        id shouldBe "4"
                        title shouldBe "Ostende / Oostende - Anvers-Central / Antwerpen-Centraal"
                        description shouldBe "We are conducting work for you between Ostende / Oostende and Anvers-Central / Antwerpen-Centraal." +
                            " Detailed information only available in French (FR) and in Dutch (NL)."
                        link shouldBe "http://www.belgianrail.be/jp/nmbs-realtime/help.exe/en?tpl=showmap_external&tplParamHimMsgInfoGroup=works&" +
                            "messageID=40825&channelFilter=timetable,rss_line_90,custom2&"
                        type shouldBe "planned"
                        timestamp shouldBe "1581691528"
                        attachment.shouldNotBeNull()
                        attachment shouldBe "http://www.belgianrail.be/jp/download/brail_him/1580998838767_NL-02045S.pdf"
                    }
                }
            }
        }
    }
}
