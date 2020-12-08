package com.jml.breaking.bad

object Config {

    const val ANDROID_GRADLE_PLUGIN = "com.android.tools.build:gradle:${Versions.BUILD_TOOLS_VERSION}"
    const val KOTLIN_GRADLE_PLUGIN = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.KOTLIN}"

    object AndroidSdk {
        const val MIN = 21
        const val COMPILE = 29
        const val TARGET = COMPILE
    }
}