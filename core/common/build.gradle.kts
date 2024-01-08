plugins {
    alias(libs.plugins.employ.android.application)
    alias(libs.plugins.employ.android.application.compose)
    alias(libs.plugins.employ.android.hilt)
}

android {
    namespace = "com.client.core.common"
}

dependencies {
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
}