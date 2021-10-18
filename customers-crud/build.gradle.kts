
plugins {
    kotlin("jvm")
    id("java")
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

}
val springBootVersion: String by project
val springDependencyManagementVersion: String by project
group = "com.messages"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    implementation(kotlin("stdlib"))
    implementation("com.h2database:h2:1.4.200")
    implementation ("org.springframework.boot:spring-boot-starter-actuator")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation(kotlin("test-junit"))
}