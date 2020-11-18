package be.johnkichi.sampleapp.features.search.di

import android.content.Context
import be.johnkichi.sampleapp.features.search.SearchFragment

fun SearchFragment.inject(context: Context) {
    DaggerSearchComponent.factory()
        .searchComponent(
            this,
            dagger.hilt.android.EntryPointAccessors.fromApplication(
                context.applicationContext,
                be.kichi.sampleapp.core.di.CoreModuleDependencies::class.java
            )
        ).inject(this)
}
