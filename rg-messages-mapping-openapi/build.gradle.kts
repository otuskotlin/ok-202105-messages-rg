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
    implementation(project(":rg-messages-transport-openapi"))

    testImplementation(kotlin("test"))
}
