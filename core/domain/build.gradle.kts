plugins {
    alias(libs.plugins.employ.android.library)
    alias(libs.plugins.employ.kotlin.detekt)
    alias(libs.plugins.ksp)
}

android {
    namespace = "com.client.employ.core.domain"
}

dependencies {
    api(projects.core.data)

    implementation(libs.javax.inject)
}