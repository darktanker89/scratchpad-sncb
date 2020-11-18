object Libs {

    const val soLoader = "com.facebook.soloader:soloader:_"
    const val flipper = "com.facebook.flipper:flipper:_"
    const val flipperNoOp = "com.facebook.flipper:flipper-noop:_"

    object Plugin {
        const val androidGradle = "com.android.tools.build:gradle:_"
        const val kotlinGradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:_"
        const val hiltGradle = "com.google.dagger:hilt-android-gradle-plugin:_"
        const val ktlintGradle = "org.jlleitschuh.gradle:ktlint-gradle:_"
    }

    object Kotlin {
        const val stdLib = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:_"
        const val gradle = "org.jetbrains.kotlin:kotlin-gradle-plugin:_"
        const val coroutines = "org.jetbrains.kotlinx:kotlinx-coroutines-core:_"
        const val coroutinesAndroid = "org.jetbrains.kotlinx:kotlinx-coroutines-android:_"
    }

    object AndroidX {
        const val appCompat = "androidx.appcompat:appcompat:_"
        const val ktxCore = "androidx.core:core-ktx:_"
        const val fragmentKtx = "androidx.fragment:fragment-ktx:_"
        const val activityKtx =  "androidx.activity:activity-ktx:1.1.0"
        const val cardView = "androidx.cardview:cardview:_"
        const val navigationUi = "androidx.navigation:navigation-ui-ktx:_"
        const val navigationFragment = "androidx.navigation:navigation-fragment-ktx:_"
        const val navigationDynamicFeatFrag = "androidx.navigation:navigation-dynamic-features-fragment:_"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:_"
        const val savedState = "androidx.savedstate:savedstate-ktx:1.1.0-beta01"


        // lifecycle
        // lifecycle
        const val lifecycleLiveData = "androidx.lifecycle:lifecycle-livedata-ktx:_"
        const val lifecycleExt = "androidx.lifecycle:lifecycle-extensions:_"
        const val lifecyleVMKtx = "androidx.lifecycle:lifecycle-viewmodel-ktx:_"
        const val lifecycleRuntimeKtx = "androidx.lifecycle:lifecycle-runtime-ktx:_"
        const val lifecycleCommonJava8  = "androidx.lifecycle:lifecycle-common-java8:2.3.0-alpha07"
        const val lifecycleVMSate = "androidx.lifecycle:lifecycle-viewmodel-savedstate:_"

        object RecyclerView {
            const val recyclerView = "androidx.recyclerview:recyclerview:1.1.0"
            const val recyclerViewSelection = "androidx.recyclerview:recyclerview-selection:1.1.0-rc02" //03
        }
    }

    object DI {
        const val hiltAndroid = "com.google.dagger:hilt-android:_"
        const val hiltAndroidCompiler = "com.google.dagger:hilt-android-compiler:_"
        const val hiltCompiler = "com.google.dagger:hilt-compiler:_"

        const val aXHiltCommon = "androidx.hilt:hilt-common:_" // 1.0.0-alpha02
        const val aXHiltLifecycleVM = "androidx.hilt:hilt-lifecycle-viewmodel:_" //1.0.0-alpha01
        const val aXHiltCompiler = "androidx.hilt:hilt-compiler:_"
    }

    object Persistence {
        const val room = "androidx.room:room-runtime:_"
        const val roomCompiler = "androidx.room:room-compiler:_"
        const val roomKtx = "androidx.room:room-ktx:_"

        object SQLDelight {
//            const val gradlePlugin = "com.squareup.sqldelight:gradle-plugin:${Versions.sqlDelight}"
//          const val androidDriver = "com.squareup.sqldelight:android-driver${Versions.sqlDelight}"
//        const val jvmDriver = "com.squareup.sqldelight:sqlite-driver:${Versions.sqlDelight}"
        }

        const val prefX = "androidx.preference:preference-ktx:_"
        const val flowPrefs = "com.github.tfcporciuncula.flow-preferences:flow-preferences:_"
        const val dataStore = "androidx.datastore:datastore-preferences:_"
    }

    object Network {
        object Retrofit {
            const val retrofit = "com.squareup.retrofit2:retrofit:_"
            const val moshiConverter = "com.squareup.retrofit2:converter-moshi:_"
        }

        object OkHttp {
            const val okHttp3 = "com.squareup.okhttp3:okhttp:_"
            const val okHttp3Interceptor = "com.squareup.okhttp3:logging-interceptor:_"
            const val mockWebServer = "com.squareup.okhttp3:mockwebserver:_"
        }

        object Moshi {
            const val moshi = "com.squareup.moshi:moshi:_"
            const val moshiCodegen = "com.squareup.moshi:moshi-kotlin-codegen:_"
            const val adapters = "com.squareup.moshi:moshi-adapters:_"
        }
    }

    object Ui {
        const val materialComponents = "com.google.android.material:material:_"
        const val insetter = "dev.chrisbanes:insetter-ktx:_"
    }

    object Test {
        const val junit4 = "junit:junit:_"
        const val androidxJunitExt = "androidx.test.ext:junit:_"
        const val espressoCore = "androidx.test.espresso:espresso-core:_"
        const val archCoreTesting = "androidx.arch.core:core-testing:_"
        const val coroutinesTest = "org.jetbrains.kotlinx:kotlinx-coroutines-test:_"
        const val kotlinTest = "io.kotlintest:kotlintest-runner-junit5:_"
        const val mockitoCore = "org.mockito:mockito-core:_"
        const val mockitoKotlin = "com.nhaarman.mockitokotlin2:mockito-kotlin:_"
    }

    const val coreDesugaring = "com.android.tools:desugar_jdk_libs:_"
}
