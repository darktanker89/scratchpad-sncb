import de.fayard.refreshVersions.bootstrapRefreshVersions

rootProject.name = "SampleApp"
include(":app")
include(":core")
include(":navigation")
include(":data:database")
include(":data:local")
include(":data:api")
include(":domain:repository")
include(":domain:models")
include(":features:about")
include(":features:announcements")
include(":features:search")

pluginManagement {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        jcenter()
    }
}

buildscript {
    repositories {
        gradlePluginPortal()
        mavenCentral()
        google()
        jcenter()
    }
    dependencies.classpath("de.fayard.refreshVersions:refreshVersions:0.9.7")
}

bootstrapRefreshVersions()
