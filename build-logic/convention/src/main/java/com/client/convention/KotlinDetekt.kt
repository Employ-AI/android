package com.client.convention

import io.gitlab.arturbosch.detekt.extensions.DetektExtension
import org.gradle.api.Project

internal fun Project.configureDetekt(extension: DetektExtension) {
    extension.apply {
        config.setFrom(file("$rootDir/app/config/detekt/config.yml"))
        parallel = true
        buildUponDefaultConfig = true
    }
}
