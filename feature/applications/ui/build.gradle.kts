plugins {
    alias(libs.plugins.employ.android.feature)
    alias(libs.plugins.employ.android.library.compose)
    alias(libs.plugins.employ.android.hilt)
    alias(libs.plugins.employ.kotlin.detekt)
}

android {
    namespace = "com.client.employ.feature.applications.ui"

    defaultConfig {
        testInstrumentationRunner = "androidx.test.runner.AndroidJUnitRunner"
    }
}

dependencies {
    implementation(projects.core.common)
    implementation(projects.core.data)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
    implementation(libs.androidx.compose.ui.test)

    testImplementation(libs.junit)
    testImplementation(libs.junit4)
    testImplementation(libs.androidx.test.core)
    testImplementation(libs.androidx.test.ext.junit)
    testImplementation(libs.androidx.test.espresso.core)
    androidTestImplementation(libs.androidx.test.core)
    androidTestImplementation(libs.androidx.test.ext.junit)
}