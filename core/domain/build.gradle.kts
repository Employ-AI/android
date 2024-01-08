plugins {
    alias(libs.plugins.employ.android.library)
    id("com.google.devtools.ksp")
}

android {
    namespace = "com.client.employ.core.domain"
}

dependencies {
    api(projects.core.data)

    implementation(libs.javax.inject)
}