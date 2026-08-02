plugins {
    alias(libs.plugins.detekt) apply false
    alias(libs.plugins.ktlint) apply false
    alias(libs.plugins.spring.boot) apply false
    alias(libs.plugins.spring.dependency.management) apply false
    alias(libs.plugins.kotlin.jvm) apply false
    alias(libs.plugins.kotlin.spring) apply false
    alias(libs.plugins.kotlin.jpa) apply false
}

group = "com.krizaldis"
version = "1.0.0-SNAPSHOT"

allprojects {
    group = rootProject.group
    version = rootProject.version
}

tasks.register("quality") {
    group = "verification"
    description = "Runs all quality checks."
    dependsOn(
        ":shared:common:check",
        ":shared:testing:check",
        ":services:order-service:check"
    )
}

tasks.register("ci") {
    group = "verification"
    description = "Runs the complete CI pipeline."
    dependsOn(
        "clean",
        "quality"
    )
}