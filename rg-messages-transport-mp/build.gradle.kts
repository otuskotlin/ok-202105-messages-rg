plugins {
    kotlin("jvm")
}

group = rootProject.group
version = rootProject.version

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))

    implementation(project(":rg-messages-transport-common"))
    implementation(project(":rg-messages-transport-mp"))

    testImplementation(kotlin("test"))
}
