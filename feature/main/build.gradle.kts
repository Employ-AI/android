plugins {
    alias(libs.plugins.employ.android.application)
    alias(libs.plugins.employ.android.application.compose)
}

android {
    namespace = "com.client.employ.feature.main"
}

dependencies {
    implementation(libs.accompanist.permissions)
    implementation(projects.core.data)
    implementation(projects.core.domain)

    testImplementation(libs.hilt.android.testing)
    testImplementation(libs.robolectric)

    implementation(libs.coil.kt)
    implementation(libs.coil.kt.compose)
}