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
        // isCoreLibraryDesugaringEnabled = true
    }
    kotlinOptions {
        jvmTarget = "1.8"
        suppressWarnings = true
    }
}

kapt {
    correctErrorTypes = true
    useBuildCache = true
    javacOptions {
        option("-Xmaxerrs", 500)
    }
}

dependencies {
    implementation(project(":domain:repository"))

    implementation(Libs.Kotlin.stdLib)
    implementation(Libs.AndroidX.ktxCore)

    implementation(Libs.AndroidX.lifecyleVMKtx)
    implementation(Libs.AndroidX.savedState)

    implementation(Libs.DI.hiltAndroid)
    kapt(Libs.DI.hiltCompiler)

    implementation(Libs.DI.aXHiltCommon)
    implementation(Libs.DI.aXHiltLifecycleVM)
    kapt(Libs.DI.aXHiltCompiler)
//    implementation(Libs.Kotlin.stdLib)
//    implementation("androidx.core:core-ktx:1.5.0-alpha02")
//    implementation("androidx.appcompat:appcompat:1.3.0-alpha02")
//    implementation("androidx.lifecycle:lifecycle-viewmodel-ktx:2.3.0-alpha07")
//
//    implementation("com.google.dagger:hilt-android:2.29.1-alpha")
//    kapt("com.google.dagger:hilt-compiler:2.29.1-alpha")
//
//    implementation("androidx.hilt:hilt-common:1.0.0-alpha02")
//    implementation("androidx.hilt:hilt-lifecycle-viewmodel:1.0.0-alpha02")
// //    implementation 'androidx.hilt:hilt-work:1.0.0-alpha02'
//    kapt("androidx.hilt:hilt-compiler:1.0.0-alpha02")
//
//    testImplementation("junit:junit:4.12")
//    androidTestImplementation("androidx.test.ext:junit:1.1.2")
//    androidTestImplementation("androidx.test.espresso:espresso-core:3.3.0")
}
