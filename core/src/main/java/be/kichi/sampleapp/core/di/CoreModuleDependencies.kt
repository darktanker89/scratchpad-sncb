package be.kichi.sampleapp.core.di

import android.app.Application
import be.johnkichi.sampleapp.repository.trains.IRailRepository
import dagger.hilt.EntryPoint
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent

@EntryPoint
@InstallIn(ApplicationComponent::class)
interface CoreModuleDependencies {

    fun exposeApplication(): Application

    fun exposeRailRepository(): IRailRepository
}
