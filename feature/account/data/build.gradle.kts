plugins {
    alias(libs.plugins.employ.android.library)
    alias(libs.plugins.employ.kotlin.detekt)
    alias(libs.plugins.employ.android.hilt)
    id("kotlinx-serialization")
}

android {
    namespace = "com.client.employ.account.data"

    buildFeatures {
        buildConfig = true
    }

    testOptions {
        unitTests {
            isIncludeAndroidResources = true
            isReturnDefaultValues = true
        }
    }
}

dependencies {
    implementation(projects.core.data)
    api(projects.core.common)

    implementation(libs.kotlinx.serialization.json)
    implementation(libs.retrofit.kotlin.serialization)
    implementation(libs.okhttp.logging)
    implementation(libs.retrofit.core)

    implementation(libs.mediapipe.tasks.text)

    implementation(platform(libs.firebase.bom))
    implementation(libs.firebase.firestore)
    implementation(libs.firebase.auth)
    implementation(libs.play.services.auth)

    testImplementation(libs.junit4)
}