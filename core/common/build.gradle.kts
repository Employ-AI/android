plugins {
    alias(libs.plugins.employ.android.library)
    alias(libs.plugins.employ.android.hilt)
}

android {
    namespace = "com.client.employ.core.common"
}

dependencies {
    testImplementation(libs.kotlinx.coroutines.test)
    testImplementation(libs.turbine)
}