pluginManagement {
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
    ":feature:main"
)

include(":build-logic")
include(":build-logic:convention")
