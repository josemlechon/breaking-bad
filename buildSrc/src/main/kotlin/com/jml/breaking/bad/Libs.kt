package com.jml.breaking.bad

object Libs {

    const val androidGradlePlugin = "com.android.tools.build:gradle:${Versions.BUILD_TOOLS_VERSION}"
    const val kotlinGradlePlugin = "org.jetbrains.kotlin:kotlin-gradle-plugin:${Versions.Kotlin.KOTLIN}"

    object Kotlin {
        const val KOTLIN = "org.jetbrains.kotlin:kotlin-stdlib-jdk8:${Versions.Kotlin.KOTLIN}"
        const val COROUTINES_CORE = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.COROUTINES}"
        const val COROUTINES_ANDROID = "org.jetbrains.kotlinx:kotlinx-coroutines-core:${Versions.Kotlin.COROUTINES}"
    }

    object UI {
        const val RECYCLERVIEW = "androidx.recyclerview:recyclerview:${Versions.UI.RECYCLER}"
        const val CARDVIEW = "androidx.cardview:cardview:${Versions.UI.CARD}"
        const val CONSTRAINT_LAYOUT =
            "androidx.constraintlayout:constraintlayout:${Versions.UI.CONSTRAINT}"
        const val DESIGN_COMPAT = "com.google.android.material:material:${Versions.UI.DESIGN}"
        const val APPCOMPAT = "androidx.appcompat:appcompat:${Versions.UI.APPCOMPAT}"
        const val GRIDLAYOUT = "androidx.gridlayout:gridlayout:${Versions.UI.GRIDLAYOUT}"

    }

    object ViewModel {
        const val VIEWMODEL: String =
            "androidx.lifecycle:lifecycle-viewmodel:${Versions.ViewModel.VIEWMODEL}"
        const val VIEWMODEL_KTX: String =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ViewModel.VIEWMODEL}"
        const val LIFECYCLE_VIEMODEL_KTX =
            "androidx.lifecycle:lifecycle-viewmodel-ktx:${Versions.ViewModel.LIFE_CYCLE_VIEWMODEL_KTX}"
        const val LIFECYCLE_EXTENSIONS =
            "androidx.lifecycle:lifecycle-extensions:${Versions.ViewModel.VIEWMODEL}"
        const val LIFECYCLE_COMPILER =
            "androidx.lifecycle:lifecycle-compiler:${Versions.ViewModel.VIEWMODEL}"
        const val LIVEDATA_EXT =
            "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.ViewModel.LIFE_CYCLE_VIEWMODEL_KTX}"
    }

    object Extensions {
        const val KTX = "androidx.core:core-ktx:${Versions.Extensions.KTX}"
    }

    object DI {
        const val KOIN_ANDROID = "org.koin:koin-android:${Versions.DI.KOIN}"
        const val KOIN_LIFECYCLE = "org.koin:koin-androidx-scope:${Versions.DI.KOIN}"
        const val KOIN_VIEWMODEL = "org.koin:koin-androidx-viewmodel:${Versions.DI.KOIN}"
        const val KOIN = "org.koin:koin-test:${Versions.DI.TEST}"
    }

    object Network {
        const val RETROFIT = "com.squareup.retrofit2:retrofit:${Versions.Network.RETROFIT}"
        const val RETROFIT_MOSHI_CONVERTER =
            "com.squareup.retrofit2:converter-moshi:${Versions.Network.RETROFIT}"
        const val OKHTTP = "com.squareup.okhttp3:okhttp:${Versions.Network.OKHTTP}"
        const val OKHHTP_LOGGER =
            "com.squareup.okhttp3:logging-interceptor:${Versions.Network.OKHTTP}"
    }

    object Navigation {
        const val NAVIGATION_FRAGMENT =
            "androidx.navigation:navigation-fragment:${Versions.AndroidX.NAVIGATION}"
        const val NAVIGATION_UI =
            "androidx.navigation:navigation-ui:${Versions.AndroidX.NAVIGATION}"
        const val NAVIGATION_UI_KTX =
            "androidx.navigation:navigation-ui-ktx:${Versions.AndroidX.NAVIGATION}"
    }

    object Utils {
        const val GLIDE = "com.github.bumptech.glide:glide:${Versions.Utils.GLIDE_VERSION}"
        const val GLIDE_COMPILER =
            "com.github.bumptech.glide:compiler:${Versions.Utils.GLIDE_VERSION}"
        const val TIMBER = "com.jakewharton.timber:timber:${Versions.Utils.TIMBER_VERSION}"
    }

    object Test {
        const val JUNIT: String = "org.junit.jupiter:junit-jupiter-api:${Versions.Test.JUNIT}"
        const val JUNIT_EXT: String = "androidx.test.ext:junit:${Versions.Test.JUNIT_EXT}"

        object AndroidX {
            const val CORE_TESTING =
                "androidx.arch.core:core-testing:${Versions.Test.AndroidX.CORE_TESTING}"
        }

        object Kotlin {
            const val MOCK_K = "io.mockk:mockk:${Versions.Test.MOCK_K}"
        }

        object OkHttp3 {
            const val MOCKWEBSERVER = "com.squareup.okhttp3:mockwebserver:${Versions.Test.OKHTTP3}"
        }
    }
}