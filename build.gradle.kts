buildscript {
    repositories {
        google()
        mavenCentral()
    }
}

plugins {
    alias(libs.plugins.android.application) apply false
    alias(libs.plugins.android.library) apply false
    alias(libs.plugins.kotlinAndroid) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.dependencyGuard) apply false
    alias(libs.plugins.hilt) apply false
    alias(libs.plugins.ksp) apply false
    alias(libs.plugins.firebase.crashlytics) apply false
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.kotlin.serialization) apply false
}
