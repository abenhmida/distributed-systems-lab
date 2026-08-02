plugins {
    alias(libs.plugins.gradle.enterprise)
}

dependencyLocking {
    lockAllConfigurations()
}