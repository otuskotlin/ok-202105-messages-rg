rootProject.name = "rg-messages"
pluginManagement {
    plugins {
        val kotlinVersion: String by settings
        val openApiVersion: String by settings

        kotlin("jvm") version kotlinVersion
        kotlin("multiplatform") version kotlinVersion
        kotlin("plugin.serialization") version kotlinVersion
        id("org.openapi.generator") version openApiVersion
        id( "org.jetbrains.kotlin.plugin.serialization") version kotlinVersion

    }
}
buildscript {
    val kotlinVersion: String by settings
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
include("ok-m1l1")
include("ok-m1l4")
include("ok-m1l5")
include("ok-m1l6")
include("ok-m1l7")

include("ok-m2l2-testing")
include("rg-messages-transport-mp")
include("rg-messages-transport-openapi")
include("rg-messages-mapping-openapi")
include("rg-messages-transport-common")
include("spring-messages-crud")
include("ktor-support-crud")
include("support-crud-transport")

