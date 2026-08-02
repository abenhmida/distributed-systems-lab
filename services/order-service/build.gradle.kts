plugins {
    kotlin("jvm")
}

dependencies {
    implementation(project(":shared:common"))
    implementation(kotlin("stdlib"))
    testImplementation(libs.junit.jupiter)
    testImplementation(libs.assertj)
    testImplementation(libs.mockk)
}

tasks.test {
    useJUnitPlatform()
}