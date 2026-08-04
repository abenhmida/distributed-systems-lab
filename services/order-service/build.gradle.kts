plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    implementation(projects.shared.common)
    implementation(projects.shared.kafka)

    implementation(libs.spring.boot.starter)
    implementation(libs.spring.boot.web)
    implementation(libs.spring.boot.validation)
    implementation(libs.spring.boot.data.jpa)
    implementation(libs.flyway)
    implementation(libs.flyway.database.postgresql)
    implementation(libs.micrometer.core)

    runtimeOnly(libs.postgresql)

    testImplementation(libs.spring.boot.test)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.assertj)
    testImplementation(libs.mockk)

    implementation(libs.kotlin.reflect)
}

tasks.test {
    useJUnitPlatform()
}