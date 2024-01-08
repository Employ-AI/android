plugins {
    alias(libs.plugins.employ.android.application)
    alias(libs.plugins.employ.android.application.compose)
    alias(libs.plugins.employ.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.client.core.data"

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    api(projects.core.common)

    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.kotlinx.serialization.json)
}