plugins {
    alias(libs.plugins.employ.android.library)
    alias(libs.plugins.employ.kotlin.detekt)
    alias(libs.plugins.employ.android.hilt)
}

android {
    namespace = "com.client.employ.core.data"

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
}