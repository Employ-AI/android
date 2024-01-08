plugins {
    alias(libs.plugins.employ.android.library)
    alias(libs.plugins.employ.android.library.compose)
}

android {
    namespace = "com.client.employ.core.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    api(libs.androidx.metrics)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}