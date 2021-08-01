group = "org.example"
version = "1.0-SNAPSHOT"
plugins {
    kotlin("jvm") apply false
    kotlin("multiplatform") apply false
}

subprojects {
    group = rootProject.group
    version = rootProject.version

    repositories {
        mavenCentral()
    }
}