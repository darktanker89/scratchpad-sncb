package be.johnkichi.sampleapp.database.di

import android.content.Context
import androidx.room.Room
import be.johnkichi.sampleapp.database.AppDb
import be.johnkichi.sampleapp.database.dao.DisturbancesDao
import be.johnkichi.sampleapp.database.dao.LaunchDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@InstallIn(ApplicationComponent::class)
@Module
object DatabaseModule {
    @Provides
    @Singleton
    fun providesDatabase(@ApplicationContext context: Context): AppDb {
        return Room.databaseBuilder(context, AppDb::class.java, "sampleapp-db")
            .fallbackToDestructiveMigration().build()
    }

    @Provides
    @Singleton
    fun providesLaunchDao(db: AppDb): LaunchDao {
        return db.launchDao()
    }

    @Provides
    @Singleton
    fun providesDisturbanceDao(db: AppDb): DisturbancesDao {
        return db.disturbanceDao()
    }
}
