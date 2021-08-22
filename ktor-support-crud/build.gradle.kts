plugins {
    kotlin("jvm")
    id("java")
    id( "org.jetbrains.kotlin.plugin.serialization")
}

val springBootVersion: String by project
val springDependencyManagementVersion: String by project
val ktorVersion: String by project
val kotlinVersion: String by project
val logbackVersion: String by project
group = "com.support"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(project(":rg-messages-mapping-openapi"))
    implementation(project(":rg-messages-transport-openapi"))
    implementation(project(":rg-messages-transport-common"))

    implementation(kotlin("stdlib"))
    implementation("com.h2database:h2:1.4.200")

    testImplementation(kotlin("test-junit"))

    implementation ("io.ktor:ktor-server-netty:$ktorVersion")
    implementation ("io.ktor:ktor-auth:$ktorVersion")
    implementation ("io.ktor:ktor-auth-jwt:$ktorVersion")
    implementation ("io.ktor:ktor-serialization:$ktorVersion")
    implementation ("ch.qos.logback:logback-classic:$logbackVersion")
}