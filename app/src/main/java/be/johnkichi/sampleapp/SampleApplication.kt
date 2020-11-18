package be.johnkichi.sampleapp

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class SampleApplication : Application() {

    override fun onCreate() {
        super.onCreate()

/*        SoLoader.init(this, false)

        if (BuildConfig.DEBUG && FlipperUtils.shouldEnableFlipper(this)) {
            Log.d("FGV", "Flipper start")
            val client = AndroidFlipperClient.getInstance(this)
            client.addPlugin(SharedPreferencesFlipperPlugin(applicationContext))
            client.addPlugin(DatabasesFlipperPlugin(applicationContext))
            client.start()
        }*/

/*        DaggerRepositoryComponent.builder()
            .context(this)
            .appDependencies(
                EntryPointAccessors.fromApplication(
                    applicationContext,
                    RepositoryModuleDependencies::class.java
                )
            )
            .build()
            .inject(this)*/
    }
}
