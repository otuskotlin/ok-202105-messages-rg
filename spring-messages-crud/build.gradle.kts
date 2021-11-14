
plugins {
    kotlin("jvm")
    id("io.spring.dependency-management") version "1.0.11.RELEASE"
    id("java")
    id("org.springframework.boot") version "2.5.4"
    id("org.flywaydb.flyway") version "7.14.1"
    kotlin("plugin.spring") version "1.5.21"
}
val springBootVersion: String by project
val springDependencyManagementVersion: String by project
group = "com.messages"
version = "1.0.0"

repositories {
    mavenCentral()
}

dependencies {
    val testContainersVersion: String by project
    val postgresDriverVersion: String by project
    implementation(project(":rg-messages-mapping-openapi"))
    implementation(project(":rg-messages-transport-openapi"))
    implementation(project(":rg-messages-transport-common"))

    implementation(kotlin("stdlib"))
    implementation ("org.springframework.boot:spring-boot-starter-actuator")

    implementation("org.hibernate:hibernate-core:5.5.7.Final")
    implementation("org.springframework.boot:spring-boot-starter:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-security:$springBootVersion")
    implementation("org.springframework.boot:spring-boot-starter-data-jpa:$springBootVersion")
    implementation("org.flywaydb:flyway-core")
    implementation("org.postgresql:postgresql:$postgresDriverVersion")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    //test
    testImplementation("org.springframework.boot:spring-boot-starter-test:$springBootVersion")
    testImplementation(kotlin("test-junit"))
    testImplementation("com.nhaarman:mockito-kotlin:1.6.0")
    testImplementation("org.junit.jupiter:junit-jupiter-api:5.8.1")
    testImplementation("org.testcontainers:postgresql:$testContainersVersion")
    testImplementation("org.testcontainers:junit-jupiter:$testContainersVersion")
}

tasks.test {
    useJUnitPlatform()
}