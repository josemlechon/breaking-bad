import com.jml.breaking.bad.Config
import com.jml.breaking.bad.Libs

plugins {
    id("com.android.application")
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")

    id("androidx.navigation.safeargs.kotlin")
}

apply(from = "../android_commons.gradle")

android {

    defaultConfig {
        minSdkVersion(Config.AndroidSdk.MIN)
        targetSdkVersion(Config.AndroidSdk.TARGET)

        applicationId = "com.jml.breaking.bad"
        versionCode = 1
        versionName = "1.0"


        buildConfigField("String", "SERVER_BASE_URL", "\"https://breakingbadapi.com/api/\"")
    }

    buildTypes {
        getByName("release") {
            isMinifyEnabled = false
            proguardFiles(getDefaultProguardFile("proguard-android.txt"), "proguard-rules.pro")
        }
    }
}

dependencies {

    implementation(kotlin("stdlib-jdk8"))

    implementation(Libs.UI.APPCOMPAT)
    implementation(Libs.UI.CONSTRAINTLAYOUT)

    implementation(Libs.DI.KOIN)
    implementation(Libs.DI.KOIN_ANDROID)
    implementation(Libs.DI.KOIN_LIFECYCLE)
    implementation(Libs.DI.KOIN_VIEWMODEL)

    implementation(Libs.ViewModel.VIEWMODEL)
    implementation(Libs.ViewModel.LIFECYCLE_EXTENSIONS)
    implementation(Libs.ViewModel.LIFECICLY_VIEMODEL_KTX)

    implementation(Libs.Extensions.KTX)

    implementation(Libs.Utils.GLIDE)
    annotationProcessor(Libs.Utils.GLIDE_COMPILER)
    implementation(Libs.Utils.TIMBER)

    implementation(Libs.Network.GSON)
    implementation(Libs.Network.OKHTTP)
    implementation(Libs.Network.OKHHTP_LOGGER)
    implementation(Libs.Network.RETROFIT)

    testImplementation(Libs.Test.JUNIT)
    androidTestImplementation(Libs.Test.JUNIT_EXT)
}
