package be.kichi.sampleapp.features.announcements.di

import android.content.Context
import be.kichi.sampleapp.core.di.CoreModuleDependencies
import be.kichi.sampleapp.features.announcements.detail.AnnouncementsDetailFragment
import be.kichi.sampleapp.features.announcements.list.AnnouncementsFragment
import dagger.hilt.android.EntryPointAccessors

// import be.kichi.sampleapp.features.announcements.list.AnnouncementsFragment

fun AnnouncementsFragment.inject(context: Context) {
    DaggerAnnouncementsComponent.factory()
        .announcementsComponent(
            this,
            EntryPointAccessors.fromApplication(
                context.applicationContext,
                CoreModuleDependencies::class.java
            )
        ).inject(this)
}

fun AnnouncementsDetailFragment.inject(context: Context) {
    DaggerAnnouncementsComponent.factory()
        .announcementsComponent(
            this,
            EntryPointAccessors.fromApplication(
                context.applicationContext,
                CoreModuleDependencies::class.java
            )
        ).inject(this)
}
