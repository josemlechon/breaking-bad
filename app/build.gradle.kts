import com.jml.breaking.bad.*

plugins {
    id("com.android.application")
   //jacoco
    checkstyle
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")

    id("com.jacoco-plugin")
    //id("jacoco-android")
}


android {
    compileSdkVersion(Config.AndroidSdk.COMPILE)
    defaultConfig {
        minSdkVersion(Config.AndroidSdk.MIN)
        targetSdkVersion(Config.AndroidSdk.TARGET)

        applicationId = "com.jml.breaking.bad"
        versionCode = 1
        versionName = "1.0"

        buildConfigField("String", "SERVER_BASE_URL", "\"https://breakingbadapi.com/api/\"")
    }

    buildTypes {
        release {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
        debug {
            isTestCoverageEnabled = true
        }
    }

    sourceSets.forEach {
        it.java.srcDir("src/${it.name}/kotlin")
    }

    compileOptions.apply {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }

    lintOptions.isAbortOnError = false
}

dependencies {

    implementation(kotlin("stdlib-jdk8"))

    implementation(UIDependenciesPlugin.APPCOMPAT)
    implementation(UIDependenciesPlugin.CONSTRAINT_LAYOUT)
    implementation(UIDependenciesPlugin.RECYCLERVIEW)
    implementation(UIDependenciesPlugin.CARDVIEW)
    implementation(UIDependenciesPlugin.DESIGN_MATERIAL)

    implementation(Libs.DI.KOIN)
    implementation(Libs.DI.KOIN_ANDROID)
    implementation(Libs.DI.KOIN_LIFECYCLE)
    implementation(Libs.DI.KOIN_VIEWMODEL)

    implementation(Libs.Navigation.NAVIGATION_FRAGMENT)
    implementation(Libs.Navigation.NAVIGATION_UI)

    implementation(Libs.ViewModel.VIEWMODEL_KTX)
    implementation(Libs.ViewModel.LIFECYCLE_EXTENSIONS)
    implementation(Libs.ViewModel.LIFECYCLE_VIEMODEL_KTX)
    implementation(Libs.ViewModel.LIVEDATA_EXT)
    kapt(Libs.ViewModel.LIFECYCLE_COMPILER)

    implementation(Libs.Extensions.KTX)

    implementation(Libs.Utils.GLIDE)
    kapt(Libs.Utils.GLIDE_COMPILER)
    implementation(Libs.Utils.TIMBER)

    implementation(Libs.Network.RETROFIT_MOSHI_CONVERTER)
    implementation(Libs.Network.OKHTTP)
    implementation(Libs.Network.OKHHTP_LOGGER)
    implementation(Libs.Network.RETROFIT)

    testImplementation(Libs.Test.JUNIT_API)
    testRuntimeOnly(Libs.Test.JUNIT_ENG)
    testImplementation(Libs.Test.Kotlin.MOCK_K) {
        because("we want to learn about this library")
    }
    testImplementation(Libs.Test.OkHttp3.MOCKWEBSERVER)
    testImplementation(Libs.Test.AndroidX.CORE_TESTING)

    androidTestImplementation(Libs.Test.JUNIT_EXT)
}
