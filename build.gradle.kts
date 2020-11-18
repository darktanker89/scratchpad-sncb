// Top-level build file where you can add configuration options common to all sub-projects/modules.
buildscript {
    val kotlin_version by extra("1.4.10")
    repositories {
        maven { url = uri("https://plugins.gradle.org/m2/") }
        google()
        jcenter()
    }
    dependencies {
        classpath(Libs.Plugin.androidGradle)
        classpath(Libs.Plugin.kotlinGradle)
        classpath(Libs.Plugin.hiltGradle)
        classpath("com.google.gms:google-services:4.3.4")
        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.10")
        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.0")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

plugins {
    id("org.jlleitschuh.gradle.ktlint") version "9.4.1"
}

apply(plugin = "org.jlleitschuh.gradle.ktlint")

allprojects {
    repositories {
        google()
        mavenCentral()
        jcenter()
        maven { setUrl("https://jitpack.io") }
        maven { setUrl("https://maven.google.com") }
    }
}

subprojects {
    apply {
        plugin("org.jlleitschuh.gradle.ktlint")
    }
    ktlint {
        version.set("0.39.0")
        // verbose.set(true)
        android.set(true)
        outputToConsole.set(true)
        // ignoreFailures.set(false)
        enableExperimentalRules.set(true)
        filter {
            exclude("**/generated/**")
            include("**/kotlin/**")
            include("**/java/**")
        }
    }
}

tasks.register("clean", Delete::class) {
    delete(rootProject.buildDir)
}
