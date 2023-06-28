buildscript {
    val agp_version by extra("8.0.0")
    repositories {
        mavenCentral()
        google()
    }

    dependencies {
        classpath(Dependencies.Google.googleServices)
        classpath(Dependencies.DaggerHilt.hiltGradlePlugin)
        classpath("com.android.tools.build:gradle:8.0.0")
    }
}


plugins {
    id(Plugins.androidApp) version Versions.androidAppVersion apply false
    id(Plugins.androidLibrary) version Versions.androidLibrary apply false
    id(Plugins.kotlinAndroid) version Versions.kotlinVersion apply false
    id(Plugins.googleServices) version Versions.Google.googleServicesVersion apply false
    `kotlin-dsl`
}

tasks.register("delete", Delete::class) {
    delete(rootProject.buildDir)
}
