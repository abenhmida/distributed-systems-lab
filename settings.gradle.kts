rootProject.name = "distributed-systems-lab"

include(
    "shared:common",
    "shared:kafka",

    "services:order-api",

    //"services:inventory-api",
    //"services:payment-api",
    //"services:shipping-api",
    "services:order-service",
    //"services:inventory-service",
    //"services:payment-service",
    //"services:shipping-service"
)

enableFeaturePreview("TYPESAFE_PROJECT_ACCESSORS")

pluginManagement {
    includeBuild("build-logic")

    repositories {
        gradlePluginPortal()
        mavenCentral()
    }
    plugins {
        kotlin("plugin.spring") version "2.3.20"
    }
}
plugins {
    id("org.gradle.toolchains.foojay-resolver-convention") version "1.0.0"
}

dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        mavenCentral()
    }
}