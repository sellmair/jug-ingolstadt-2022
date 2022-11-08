@file:Suppress("OPT_IN_USAGE")

plugins {
    kotlin("multiplatform")
}

kotlin {
    targetHierarchy.default()

    macosArm64()
    macosX64()
    iosX64()
    iosArm64()
    iosSimulatorArm64()

    jvm()
}