plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("kapt")
    id("dagger.hilt.android.plugin")
}

android {
    compileSdkVersion(ProjectProperties.compileSdk)

    defaultConfig {
        applicationId = ProjectProperties.applicationId
        minSdkVersion(ProjectProperties.minSdk)
        targetSdkVersion(ProjectProperties.targetSdk)
        versionCode = ProjectProperties.versionCode
        versionName = ProjectProperties.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(
                getDefaultProguardFile("proguard-android-optimize.txt"),
                "proguard-rules.pro"
            )
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
        // isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    buildFeatures.viewBinding = true
    buildFeatures.dataBinding = true

    sourceSets {
        val kotlinAddintionalSourceSets = project.file("src/main/kotlin")
        findByName("main")?.java?.srcDirs(kotlinAddintionalSourceSets)
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
    // dynamicFeatures = mutableSetOf(":features:search", ":features:about", ":features:announcements")
    dynamicFeatures = mutableSetOf(":features:search", ":features:announcements", ":features:about")
}

dependencies {
    implementation(project(":core"))
    implementation(project(":domain:repository"))
    implementation(project(":domain:models"))
    implementation(project(":navigation"))

    //region di
    implementation(Libs.DI.hiltAndroid)
    kapt(Libs.DI.hiltAndroidCompiler)

    implementation(Libs.DI.aXHiltCommon)
    implementation(Libs.DI.aXHiltLifecycleVM)
    kapt(Libs.DI.aXHiltCompiler)
    //endregion

    //region kotlin
    implementation(Libs.Kotlin.stdLib)
    implementation(Libs.Kotlin.coroutines)
    //endregion
    implementation(Libs.AndroidX.ktxCore)
    //region ui
    implementation(Libs.AndroidX.appCompat)
    implementation(Libs.AndroidX.constraintLayout)
    implementation(Libs.Ui.materialComponents)
    //endregion
    //region tests
    testImplementation(Libs.Test.junit4)
    testImplementation(Libs.Test.coroutinesTest)
    androidTestImplementation(Libs.Test.androidxJunitExt)
    androidTestImplementation(Libs.Test.espressoCore)
    testImplementation(Libs.Test.mockitoCore)
    testImplementation(Libs.Test.mockitoKotlin)
    //endregion

    implementation(Libs.AndroidX.navigationUi)
    implementation(Libs.AndroidX.navigationFragment)
    implementation(Libs.AndroidX.navigationDynamicFeatFrag)

    implementation(Libs.Ui.insetter)

    implementation("com.google.android.play:core:1.8.2")

    debugImplementation(Libs.soLoader)
    debugImplementation(Libs.flipper)
    releaseImplementation(Libs.flipperNoOp)

    implementation(Libs.AndroidX.lifecycleLiveData)
    implementation(Libs.AndroidX.lifecyleVMKtx)
    implementation(Libs.AndroidX.lifecycleCommonJava8)
    implementation(Libs.AndroidX.lifecycleVMSate)
    implementation(Libs.AndroidX.lifecycleExt)
    implementation(Libs.AndroidX.lifecycleRuntimeKtx)
    implementation(Libs.AndroidX.activityKtx)
}
