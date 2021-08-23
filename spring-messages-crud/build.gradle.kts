
plugins {
    kotlin("jvm")
    id("org.springframework.boot") version "2.5.2"
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("java")
}
val springBootVersion: String by project
val springDependencyManagementVersion: String by project
group = "com.messages"
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
    implementation ("org.springframework.boot:spring-boot-starter-actuator")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation(kotlin("test-junit"))
}