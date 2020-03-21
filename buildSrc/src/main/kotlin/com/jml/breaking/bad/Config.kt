package com.jml.breaking.bad

object Config {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.BUILD_TOOLS_VERSION}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.KOTLIN}"

    const val androidApplication = "com.android.application"
    const val androidLibrary = "com.android.library"
    const val kotlinAndroid = "kotlin-android"
    const val kotlinAndroidExtensions = "kotlin-android-extensions"
    const val kotlinKapt = "kotlin-kapt"

    object AndroidSdk {
        const val MIN = 21
        const val COMPILE = 28
        const val TARGET = COMPILE
    }

    object ProjectModules {
        const val CORE = ":core"
    }
}