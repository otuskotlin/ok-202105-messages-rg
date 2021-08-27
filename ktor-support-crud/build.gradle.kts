plugins {
    kotlin("jvm")
    id("java")
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("org.jetbrains.kotlin.plugin.serialization")
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
    mavenLocal()
    jcenter()
    maven("https://jcenter.bintray.com")
}
buildscript {
    val kotlinVersion: String by project
    repositories {
        jcenter()
        mavenCentral()
        mavenLocal()
        maven("https://kotlin.bintray.com/ktor")
    }

    dependencies {

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}
dependencies {
    implementation(project(":support-crud-transport"))

    implementation(kotlin("stdlib"))
    implementation("com.h2database:h2:1.4.200")

    testImplementation(kotlin("test-junit"))
    implementation ("org.springframework.boot:spring-boot-starter-web")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-auth:$ktorVersion")
    implementation("io.ktor:ktor-auth-jwt:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
}