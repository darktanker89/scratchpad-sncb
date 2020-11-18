package be.kichi.sampleapp.features.announcements.di

import androidx.fragment.app.Fragment
import be.kichi.sampleapp.core.di.CoreModuleDependencies
import be.kichi.sampleapp.features.announcements.detail.AnnouncementsDetailFragment
import be.kichi.sampleapp.features.announcements.list.AnnouncementsFragment
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [CoreModuleDependencies::class],
    modules = [AnnouncementsModule::class]
)
interface AnnouncementsComponent {

    fun inject(fragment: AnnouncementsFragment)
    fun inject(fragment: AnnouncementsDetailFragment)

    fun fragment(): Fragment

    @Component.Factory
    interface Factory {
        fun announcementsComponent(
            @BindsInstance fragment: Fragment,
            loginModuleDependencies: CoreModuleDependencies
        ): AnnouncementsComponent
    }
}
