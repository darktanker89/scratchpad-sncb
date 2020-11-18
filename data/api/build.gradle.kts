plugins {
    id("com.android.library")
    kotlin("android")
    kotlin("kapt")
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
            proguardFiles(getDefaultProguardFile("proguard-android-optimize.txt"), "proguard-rules.pro")
        }
    }
    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
    kotlinOptions {
        jvmTarget = "1.8"
    }
}

dependencies {
    implementation(project(mapOf("path" to ":domain:models")))

    //region kotlin
    implementation(Libs.Kotlin.stdLib)
    implementation(Libs.Kotlin.coroutines)
    implementation(Libs.Kotlin.coroutinesAndroid)
    //endregion
    //region di
    implementation(Libs.DI.hiltAndroid)
    kapt(Libs.DI.hiltAndroidCompiler)
    //endregion
    //region net
    api(Libs.Network.OkHttp.okHttp3)
    api(Libs.Network.OkHttp.okHttp3Interceptor)
    api(Libs.Network.Retrofit.retrofit)
    api(Libs.Network.Retrofit.moshiConverter)
    api(Libs.Network.Moshi.moshi)
    kapt(Libs.Network.Moshi.moshiCodegen)
    api(Libs.Network.Moshi.adapters)
    //endregion
    //region tests
    testImplementation(Libs.Test.junit4)
    testImplementation(Libs.Test.kotlinTest)
    testImplementation(Libs.Network.OkHttp.mockWebServer)
    androidTestImplementation(Libs.Test.androidxJunitExt)
    androidTestImplementation(Libs.Test.espressoCore)
    //endregion
}
