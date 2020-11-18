package be.johnkichi.sampleapp.api

import be.johnkichi.sampleapp.api.spacex.model.ApiLaunch
import be.johnkichi.sampleapp.api.util.useJSON
import be.johnkichi.sampleapp.api.util.useJSONAdapter
import io.kotlintest.assertSoftly
import io.kotlintest.matchers.collections.shouldContain
import io.kotlintest.matchers.collections.shouldContainAll
import io.kotlintest.matchers.types.shouldNotBeNull
import io.kotlintest.shouldBe
import io.kotlintest.specs.AnnotationSpec

internal class LaunchParsingTest : AnnotationSpec() {

    @Test
    fun testLaunchApiParsing() {
        val launchJson = useJSON("sampledata/one_launch.json")
        val jsonAdapter = useJSONAdapter<ApiLaunch>()
        val launch = jsonAdapter.fromJson(launchJson)

        assertSoftly {
            with(launch) {
                this.shouldNotBeNull()
                flightNumber shouldBe 65
                missionName shouldBe "Telstar 19V"
                missionId shouldContain "F4F83DE"
                launchYear shouldBe "2018"
                // launchDate shouldBe SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'").parse("2018-07-22T05:50:00.000Z")
                isTentative shouldBe false
                tentativeMaxPrecision shouldBe "hour"
                tbd shouldBe false
                launchWindow shouldBe 7200
                ships shouldContainAll listOf<String>(
                    "GOPURSUIT",
                    "GOQUEST",
                    "HAWK",
                    "OCISLY"
                )
                launchSuccess shouldBe true
                details shouldBe "SSL-manufactured communications satellite intended to be placed at 63° West over the Americas." +
                    " At 7,075 kg, it became the heaviest commercial communications satellite ever launched."
                upcoming shouldBe false
                // staticFireDate shouldBe "2018-07-18T21:00:00.000Z"
            }
        }
    }
}
