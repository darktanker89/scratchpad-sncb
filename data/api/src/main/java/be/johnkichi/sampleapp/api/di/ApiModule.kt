package be.johnkichi.sampleapp.api.di

import be.johnkichi.sampleapp.api.base.EnumRetrofitConverterFactory
import be.johnkichi.sampleapp.api.base.NetworkResponseAdapterFactory
import be.johnkichi.sampleapp.api.rail.models.request.FieldOccupancyAdapter
import be.johnkichi.sampleapp.api.rail.service.IRailService
import be.johnkichi.sampleapp.api.spacex.service.SpaceXService
import com.squareup.moshi.Moshi
import com.squareup.moshi.adapters.Rfc3339DateJsonAdapter
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import java.util.*
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object ApiModule {
    @Provides
    @Singleton
    // fun providesRetrofit(client: OkHttpClient, moshi: Moshi, @Named("spaceXurl") baseUrl: String): Retrofit {
    fun providesRetrofit(client: OkHttpClient, moshi: Moshi, @Named("irailUrl") baseUrl: String): Retrofit {
        return Retrofit.Builder()
            // .baseUrl("https://retroftcoroutines.free.beeceptor.com/")
            .addCallAdapterFactory(NetworkResponseAdapterFactory())
            .addConverterFactory(MoshiConverterFactory.create(moshi))
            .addConverterFactory(EnumRetrofitConverterFactory())
            .baseUrl(baseUrl)
            .client(client)
            .build()
    }

    @Provides
    @Singleton
    fun providesOkHttp(httpLoggingInterceptor: HttpLoggingInterceptor): OkHttpClient {
        return OkHttpClient.Builder()
            .connectTimeout(5, TimeUnit.SECONDS)
            .writeTimeout(5, TimeUnit.SECONDS)
            .readTimeout(5, TimeUnit.SECONDS)
            .addInterceptor(httpLoggingInterceptor)
            .build()
    }

    @Provides
    @Singleton
    fun providesHttpLoggingInterceptor(): HttpLoggingInterceptor {
        // val logLevel = if (BuildConfig.DEBUG) HttpLoggingInterceptor.Level.BODY else HttpLoggingInterceptor.Level.NONE
        val logLevel = HttpLoggingInterceptor.Level.BODY
        return HttpLoggingInterceptor().setLevel(logLevel)
    }

    @Provides
    @Singleton
    fun providesMoshi(): Moshi {
        return Moshi.Builder()
            .add(Date::class.java, Rfc3339DateJsonAdapter().nullSafe())
            .add(FieldOccupancyAdapter())
            .build()
    }

    @Provides
    @Named("spaceXurl")
    fun providesSpaceXurl(): String {
        return "https://api.spacexdata.com/"
    }

    @Provides
    @Singleton
    fun providesSpaceXservice(retrofit: Retrofit): SpaceXService {
        return retrofit.create(SpaceXService::class.java)
    }

    @Provides
    @Named("irailUrl")
    fun providesRailUrl(): String {
        return "https://api.irail.be"
    }

    @Provides
    @Singleton
    fun providesRailService(retrofit: Retrofit): IRailService {
        return retrofit.create(IRailService::class.java)
    }
}
