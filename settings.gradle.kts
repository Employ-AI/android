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

include(":feature:account:data")
include(":feature:account:domain")
include(":feature:account:ui")

include(":feature:applications:data")
include(":feature:applications:domain")
include(":feature:applications:ui")

include(":feature:auth:data")
include(":feature:auth:domain")
include(":feature:auth:ui")

include(":feature:dashboard:data")
include(":feature:dashboard:domain")
include(":feature:dashboard:ui")

include(":feature:matching:data")
include(":feature:matching:domain")
include(":feature:matching:ui")

include(":feature:onboarding:data")
include(":feature:onboarding:domain")
include(":feature:onboarding:ui")

include(":feature:profile:data")
include(":feature:profile:domain")
include(":feature:profile:ui")
