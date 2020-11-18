plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

android {
    compileSdkVersion(ProjectProperties.compileSdk)

    defaultConfig {
        minSdkVersion(ProjectProperties.minSdk)
        targetSdkVersion(ProjectProperties.targetSdk)
        versionCode = ProjectProperties.versionCode
        versionName = ProjectProperties.versionName

        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
        consumerProguardFiles("consumer-rules.pro")
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
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }

    sourceSets {
        val navArgsSourceSets = project.file("build/generated/source/navigation-args/debug")
        findByName("main")?.java?.srcDirs(navArgsSourceSets)
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
    implementation(fileTree(mapOf("dir" to "libs", "include" to listOf("*.jar"))))

    //region kotlin
    implementation(Libs.Kotlin.stdLib)
    //endregion
    implementation(Libs.AndroidX.ktxCore)
    //region navigation
    implementation(Libs.AndroidX.navigationFragment)
    implementation(Libs.AndroidX.navigationUi)
    //endregion
    //region tests
    testImplementation(Libs.Test.junit4)
    androidTestImplementation(Libs.Test.androidxJunitExt)
    androidTestImplementation(Libs.Test.espressoCore)
    androidTestImplementation(Libs.Test.archCoreTesting)
    //endregion

    // region preview enforce hardrule needed
    // implementation(project(":features:search")) hang canary 14
    // endregion
}
