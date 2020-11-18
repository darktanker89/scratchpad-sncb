plugins {
    id("com.android.dynamic-feature")
    kotlin("android")
    kotlin("kapt")
}

android {
    compileSdkVersion(ProjectProperties.compileSdk)

    defaultConfig {
        applicationId = "be.johnkichi.sampleapp.features.search"
        minSdkVersion(ProjectProperties.minSdk)
        targetSdkVersion(ProjectProperties.targetSdk)
        versionCode = ProjectProperties.versionCode
        versionName = ProjectProperties.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
    buildFeatures.viewBinding = true
    kapt {
        correctErrorTypes = true
    }
    lintOptions {
        isCheckReleaseBuilds = false
        // Or, if you prefer, you can continue to check for errors in release builds,
        // but continue the build even when errors are found:
        isCheckAllWarnings = false
        isAbortOnError = false
        isCheckDependencies = false
        isCheckGeneratedSources = false
        isWarningsAsErrors = false
    }
}

dependencies {
    //region internal modul
    implementation(project(":core"))
    implementation(project(":app"))
    implementation(project(":domain:repository"))
    implementation(project(":domain:models"))
    implementation(project(":navigation"))
    //endregion

    //region base
    implementation(Libs.Kotlin.stdLib)
    implementation(Libs.AndroidX.ktxCore)
    //endregion

    //region ui
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.fragmentKtx)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.Ui.materialComponents)
    implementation("xyz.quaver:floatingsearchview:1.0.7")
    implementation(Libs.AndroidX.RecyclerView.recyclerView)
    //endregion

    //region lifecycle
    implementation(Libs.AndroidX.lifecycleLiveData)
    implementation(Libs.AndroidX.lifecyleVMKtx)
    implementation(Libs.AndroidX.lifecycleCommonJava8)
    implementation(Libs.AndroidX.lifecycleVMSate)
    implementation(Libs.AndroidX.lifecycleExt)
    implementation(Libs.AndroidX.lifecycleRuntimeKtx)
    //endregion

    //region DI
    implementation(Libs.DI.hiltAndroid)
    kapt(Libs.DI.hiltCompiler)

    implementation(Libs.DI.aXHiltCommon)
    implementation(Libs.DI.aXHiltLifecycleVM)
    kapt(Libs.DI.aXHiltCompiler)
    //endregion
}
