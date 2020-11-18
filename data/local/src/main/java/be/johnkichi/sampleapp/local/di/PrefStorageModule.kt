package be.johnkichi.sampleapp.local.di

import android.content.Context
import be.johnkichi.sampleapp.local.flowprefs.PreferencesHelper
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object PrefStorageModule {
    @Provides
    @Singleton
    fun providesPreferences(@ApplicationContext context: Context): PreferencesHelper {
        return PreferencesHelper(context)
    }
}
