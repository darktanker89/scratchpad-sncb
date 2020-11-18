package be.johnkichi.sampleapp.api.base

import be.johnkichi.sampleapp.api.di.ApiModule
import io.kotlintest.Spec
import io.kotlintest.specs.DescribeSpec
import okhttp3.mockwebserver.MockWebServer
import retrofit2.Retrofit

internal abstract class BaseApiTest : DescribeSpec() {

    protected lateinit var server: MockWebServer
    protected lateinit var retrofit: Retrofit

    override fun beforeSpec(spec: Spec) {
        super.beforeSpec(spec)
        server = MockWebServer()
        retrofit =
            ApiModule.providesRetrofit(
                ApiModule.providesOkHttp(ApiModule.providesHttpLoggingInterceptor()),
                ApiModule.providesMoshi(),
                server.url("/").toString()
            )
    }

    override fun afterSpec(spec: Spec) {
        super.afterSpec(spec)
        server.close()
    }
}
