@file:Suppress("OPT_IN_USAGE")

plugins {
    kotlin("multiplatform")
    application
}

kotlin {
    targetHierarchy.default()

    macosArm64()
    macosX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

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