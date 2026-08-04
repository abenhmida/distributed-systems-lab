plugins {
    kotlin("jvm")
}

dependencies {
    implementation(kotlin("stdlib"))
    testImplementation(libs.junit.jupiter)
    testRuntimeOnly(libs.junit.platform.launcher)
    testImplementation(libs.assertj)
    testImplementation(libs.mockk)
}

tasks.test {
    useJUnitPlatform()
}