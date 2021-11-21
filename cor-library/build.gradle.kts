plugins {
    kotlin("jvm")
    id("java")
    id("org.jetbrains.kotlin.plugin.serialization")
}



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
    val coroutinesVersion:String by project

    implementation(kotlin("stdlib"))

    testImplementation(kotlin("test-junit"))
    implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:$coroutinesVersion")
    implementation("ch.qos.logback:logback-classic:$logbackVersion")
    /**
     * Зависимости ниже мы забрали из сгенерированного build.gradle. Они нужны для компиляции подпроекта
     */
    implementation("com.fasterxml.jackson.module:jackson-module-kotlin:$jacksonVersion")
    implementation("com.fasterxml.jackson.datatype:jackson-datatype-jsr310:$jacksonVersion")
}
