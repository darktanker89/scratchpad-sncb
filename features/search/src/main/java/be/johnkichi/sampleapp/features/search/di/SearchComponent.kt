package be.johnkichi.sampleapp.features.search.di

import androidx.fragment.app.Fragment
import be.johnkichi.sampleapp.features.search.SearchFragment
import be.kichi.sampleapp.core.di.CoreModuleDependencies
import dagger.BindsInstance
import dagger.Component

@Component(
    dependencies = [CoreModuleDependencies::class],
    modules = [SearchModule::class]
)
interface SearchComponent {

    fun inject(fragment: SearchFragment)

    fun fragment(): Fragment

    @Component.Factory
    interface Factory {
        fun searchComponent(
            @BindsInstance fragment: Fragment,
            loginModuleDependencies: CoreModuleDependencies
        ): SearchComponent
    }
}
