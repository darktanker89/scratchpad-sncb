package be.johnkichi.sampleapp.features.search.di

import be.johnkichi.sampleapp.features.search.SearchViewModel_HiltModule
import be.kichi.sampleapp.core.di.FragmentViewModelModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module(
    includes = [
        SearchViewModel_HiltModule::class,
        FragmentViewModelModule::class
    ]
)
@InstallIn(FragmentComponent::class)
abstract class SearchModule {

    companion object {
        @Provides
        fun providesString(): String = "unString"
    }
}
