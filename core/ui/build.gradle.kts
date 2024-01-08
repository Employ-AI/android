plugins {
    alias(libs.plugins.employ.android.library)
    alias(libs.plugins.employ.android.library.compose)
    alias(libs.plugins.employ.kotlin.detekt)
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

    testImplementation(libs.junit)
    testImplementation(libs.junit4)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.test.ext.junit)
    testImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
}