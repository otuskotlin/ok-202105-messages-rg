plugins {
    kotlin("jvm")
    id("java")
    id("org.openapi.generator")
    kotlin("plugin.serialization")
}
/**
 * Настраиваем генерацию здесь
 */
openApiGenerate {
    val openapiGroup = "${rootProject.group}.support.openapi"
    generatorName.set("kotlin-server") // Это и есть активный генератор
    packageName.set(openapiGroup)
    apiPackage.set("$openapiGroup.api")
    modelPackage.set("$openapiGroup.models")
    invokerPackage.set("$openapiGroup.invoker")
    inputSpec.set("$rootDir/spec/support-crud.yaml")

    /**
     * Здесь указываем, что нам нужны только модели, все остальное не нужно
     */
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

/**
 * Здесь подключаем сгенерированные исходники к списку директорий компилятора, чтоб он их видел при компиляции
 */
sourceSets {
    main {
        java.srcDir("$buildDir/generate-resources/main/src/main/kotlin")
    }
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
        maven { setUrl("https://dl.bintray.com/kotlin/ktor") }
        jcenter()
        mavenCentral()
        mavenLocal()
    }

    dependencies {

        classpath("org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlinVersion")
    }
}
dependencies {
    val jacksonVersion: String by project
    implementation(kotlin("stdlib"))
    implementation("io.ktor:ktor-serialization:$ktorVersion")
    testImplementation(kotlin("test-junit"))
    implementation("org.jetbrains.kotlinx:kotlinx-serialization-json:1.3.1")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    /**
     * Зависимости ниже мы забрали из сгенерированного build.gradle. Они нужны для компиляции подпроекта
     */
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
}

tasks {
    /**
     * Устанавливаем зависимость компиляции от генерации исходников. Компиляция начнется только после генерации
     */
    compileKotlin {
        dependsOn(openApiGenerate)
    }
}