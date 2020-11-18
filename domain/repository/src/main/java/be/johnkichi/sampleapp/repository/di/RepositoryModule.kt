package be.johnkichi.sampleapp.repository.di

import be.johnkichi.sampleapp.api.di.ApiModule
import be.johnkichi.sampleapp.database.di.DatabaseModule
import be.johnkichi.sampleapp.repository.ILaunchRepository
import be.johnkichi.sampleapp.repository.LaunchesRepository
import be.johnkichi.sampleapp.repository.trains.IRailRepository
import be.johnkichi.sampleapp.repository.trains.RailRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import javax.inject.Singleton

@Module(includes = [DatabaseModule::class, ApiModule::class])
@InstallIn(ApplicationComponent::class)
abstract class RepositoryModule {
    @Singleton
    @Binds
    abstract fun bindsLaunchRepository(launchRepositoryImpl: LaunchesRepository): ILaunchRepository

    @Singleton
    @Binds
    abstract fun bindsRailRepository(railRepositoryImpl: RailRepository): IRailRepository
}
