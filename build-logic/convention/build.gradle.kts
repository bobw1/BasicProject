import org.jetbrains.kotlin.gradle.dsl.JvmTarget

plugins {
    `version-catalog`
    `kotlin-dsl`
    `java-gradle-plugin`
}

repositories {
    google()
    gradlePluginPortal()
    mavenCentral()
}

group = "com.basic.convention"

java {
    sourceCompatibility = JavaVersion.VERSION_17
    targetCompatibility = JavaVersion.VERSION_17
}

kotlin {
    compilerOptions {
        jvmTarget = JvmTarget.JVM_17
    }
}

dependencies {
    compileOnly("com.android.tools.build:gradle:8.5.2")
    compileOnly("com.android.tools:common:31.5.2")
    compileOnly("org.jetbrains.kotlin:kotlin-gradle-plugin:1.9.0")
    compileOnly("com.google.devtools.ksp:com.google.devtools.ksp.gradle.plugin:2.0.0-1.0.21")
    compileOnly("androidx.room:room-gradle-plugin:2.6.1")
}

tasks {
    validatePlugins {
        enableStricterValidation = true
        failOnWarning = true
    }
}

gradlePlugin {
    plugins {
        register("androidApplication") {
            id = "basic.application"
            implementationClass = "com.basic.convention.AndroidApplicationConventionPlugin"
        }
        register("androidFeature") {
            id = "basic.feature"
            implementationClass = "com.basic.convention.AndroidFeatureConventionPlugin"
        }
        register("androidRoom") {
            id = "basic.room"
            implementationClass = "com.basic.convention.AndroidRoomConventionPlugin"
        }
    }
}