plugins {
    `kotlin-dsl`
}

repositories {
    gradlePluginPortal()
    mavenCentral()
}

java {
    toolchain {
        languageVersion.set(JavaLanguageVersion.of(21))
    }
}

dependencies {
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:2.3.20")
    implementation("org.springframework.boot:spring-boot-gradle-plugin:3.5.0")
    implementation("io.spring.gradle:dependency-management-plugin:1.1.7")
}