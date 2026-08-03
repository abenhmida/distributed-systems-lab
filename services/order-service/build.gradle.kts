plugins {
    id("org.springframework.boot")
    id("io.spring.dependency-management")
    kotlin("jvm")
    kotlin("plugin.spring")
    kotlin("plugin.jpa")
}

dependencies {
    //implementation(project(":shared:common"))
    implementation(projects.shared.common)
    implementation(libs.spring.boot.starter)
    implementation(libs.spring.boot.web)
    implementation(libs.spring.boot.validation)
    implementation(libs.spring.boot.data.jpa)
    implementation(libs.flyway)
    runtimeOnly(libs.postgresql)
    testImplementation(libs.spring.boot.test)
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.assertj)
    testImplementation(libs.mockk)
}

tasks.test {
    useJUnitPlatform()
}