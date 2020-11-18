package be.kichi.sampleapp.features.announcements.di

import be.kichi.sampleapp.core.di.FragmentViewModelModule
import be.kichi.sampleapp.features.announcements.detail.AnnouncementsDetailViewModel_HiltModule
import be.kichi.sampleapp.features.announcements.list.AnnouncementsViewModel_HiltModule
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent

@Module(
    includes = [
        AnnouncementsDetailViewModel_HiltModule::class,
        AnnouncementsViewModel_HiltModule::class,
        FragmentViewModelModule::class
    ]
)
@InstallIn(FragmentComponent::class)
abstract class AnnouncementsModule {

    companion object {
        @Provides
        fun providesString(): String = "unString"
    }
}
