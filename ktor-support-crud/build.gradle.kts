plugins {
    kotlin("jvm")
    id("java")
    id("org.springframework.boot")
    kotlin("plugin.serialization")
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
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
    val kotlinVersion:String by project
    val coroutinesVersion:String by project
    implementation(project(":support-crud-transport"))
    implementation(project(":cor-library"))

    implementation(kotlin("stdlib"))
    implementation("com.h2database:h2:1.4.200")
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")

    implementation ("org.springframework.boot:spring-boot-starter-web:$springBootVersion")
    implementation("io.ktor:ktor-server-netty:$ktorVersion")
    implementation("io.ktor:ktor-auth:$ktorVersion")
    implementation("io.ktor:ktor-auth-jwt:$ktorVersion")
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    testImplementation(kotlin("test-junit"))
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
}
tasks.test {
    useJUnitPlatform()
}