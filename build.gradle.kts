@file:Suppress("OPT_IN_USAGE")

import org.jetbrains.kotlin.gradle.plugin.mpp.KotlinNativeTarget

plugins {
    kotlin("multiplatform")
    application
}

kotlin {
    macosArm64()
    macosX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    val commonMain by sourceSets.getting
    val appleMain by sourceSets.creating

    appleMain.dependsOn(commonMain)

    targets.withType<KotlinNativeTarget>()
        .matching { it.konanTarget.family.isAppleFamily }
        .configureEach { compilations.getByName("main").defaultSourceSet.dependsOn(appleMain) }

    commonMain.dependencies {
        implementation("io.ktor:ktor-client-core:2.1.3")
        implementation("com.squareup.okio:okio:3.2.0")
        implementation("org.jetbrains.kotlinx:kotlinx-coroutines-core:1.6.4")
    }

    appleMain.dependencies {
        implementation("io.ktor:ktor-client-darwin:2.1.3")
    }

    jvm {
        withJava()
    }

    macosArm64().binaries.executable {
        entryPoint = "org.jetbrains.sample.main"
        baseName = "jug"
    }
}

application {
    mainClass.set("org.jetbrains.sample.MainKt")
}