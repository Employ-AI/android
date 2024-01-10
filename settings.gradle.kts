pluginManagement {
    includeBuild("build-logic")
    repositories {
        google()
        mavenCentral()
        gradlePluginPortal()
    }
}
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        google()
        mavenCentral()
    }
}

rootProject.name = "Employ"
enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

include(":app")
include(
    ":core",
    ":core:data",
    ":core:domain",
    ":core:ui",
    ":core:common",
    ":core:design-system"
)

include(
    ":feature",
    ":feature:dashboard",
    ":feature:applications",
    ":feature:profile",
    ":feature:onboarding",
)