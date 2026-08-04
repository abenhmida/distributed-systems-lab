plugins {
    kotlin("jvm")
    kotlin("plugin.spring")
}

dependencies {
    implementation(projects.shared.common)

    implementation(libs.jackson.module.kotlin)

    implementation(libs.spring.boot)
    implementation(libs.spring.kafka)
    implementation(libs.kafka.clients)

    implementation(kotlin("stdlib"))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.assertj)
    testImplementation(libs.mockk)
    testImplementation(kotlin("test"))
}

tasks.test {
    useJUnitPlatform()
}
