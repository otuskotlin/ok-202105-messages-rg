
plugins {
    kotlin("jvm")
    id("java")
    id("org.springframework.boot") version "2.5.2"
    id("org.openapi.generator")
    id("io.spring.dependency-management") version "1.0.11.RELEASE"

}
val springBootVersion: String by project
val springDependencyManagementVersion: String by project
group = "com.messages"
version = "1.0.0"

repositories {
    mavenCentral()
}
sourceSets {
    main {
        java.srcDir("$buildDir/generate-resources/main/src/main/kotlin")
    }
}
openApiGenerate {
    val openapiGroup = "${rootProject.group}.openapi"
    generatorName.set("kotlin") // Это и есть активный генератор
    packageName.set(openapiGroup)
    apiPackage.set("$openapiGroup.api")
    modelPackage.set("$openapiGroup.models")
    invokerPackage.set("$openapiGroup.invoker")
    inputSpec.set("$rootDir/customers-crud-in-memory/src/main/resources/api/customer.yaml")

    globalProperties.apply {
        put("models", "")
        put("modelDocs", "false")
    }

    configOptions.set(mapOf(
        "dateLibrary" to "string",
        "enumPropertyNaming" to "UPPERCASE",
        "serializationLibrary" to "jackson",
        "collectionType" to "list"
    ))
}

dependencies {
    val ehcacheVersion: String by project
    val jacksonVersion: String by project
    implementation("com.atlassian.oai:swagger-request-validator-springmvc:2.2.2")
    implementation("guru.springframework:spring-cloud-contract-oa3:2.1.2.0")
    implementation("com.atlassian.oai:swagger-request-validator-core:2.2.2")
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
    implementation ("org.springframework.boot:spring-boot-starter-actuator:2.5.6")
    implementation(kotlin("stdlib"))
    implementation("org.ehcache:ehcache:$ehcacheVersion")
    implementation ("org.springframework.boot:spring-boot-starter-web")
    testImplementation ("org.springframework.boot:spring-boot-starter-test")
    testImplementation(kotlin("test-junit"))
}
tasks {
    compileKotlin {
        dependsOn(openApiGenerate)
    }
}
tasks.test {
    useJUnitPlatform()
}