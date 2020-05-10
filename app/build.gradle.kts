import com.jml.breaking.bad.Config
import com.jml.breaking.bad.Libs

plugins {
    id("com.android.application")
  //  jacoco
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")

    id("jacoco-android")
    id("org.sonarqube")
    id("androidx.navigation.safeargs.kotlin")
}



/*
jacoco {
    toolVersion = "0.8.5"
    reportsDir = file("$buildDir/jacoco")
}

tasks {
    withType<Test> {
        configure<JacocoTaskExtension> {
            isIncludeNoLocationClasses = true
        }
    }
}

 */
apply(from = "../sonar.gradle")
apply(from = "../jacoco.gradle")
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
        getByName("debug") {
            isTestCoverageEnabled = true
        }
    }
}


dependencies {

    implementation(kotlin("stdlib-jdk8"))

    implementation(Libs.UI.APPCOMPAT)
    implementation(Libs.UI.CONSTRAINT_LAYOUT)
    implementation(Libs.UI.RECYCLERVIEW)
    implementation(Libs.UI.CARDVIEW)

    implementation(Libs.DI.KOIN)
    implementation(Libs.DI.KOIN_ANDROID)
    implementation(Libs.DI.KOIN_LIFECYCLE)
    implementation(Libs.DI.KOIN_VIEWMODEL)

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

    testImplementation(Libs.Test.JUNIT)
    testImplementation(Libs.Test.Kotlin.MOCK_K) {
        because("we want to learn about this library")
    }
    testImplementation(Libs.Test.OkHttp3.MOCKWEBSERVER)
    testImplementation(Libs.Test.AndroidX.CORE_TESTING)

    androidTestImplementation(Libs.Test.JUNIT_EXT)
}