import com.jml.breaking.bad.Config
import com.jml.breaking.bad.Libs
import com.jml.breaking.bad.debug
import com.jml.breaking.bad.release

//https://github.com/kittinunf/Fuse/blob/master/build.gradle.kts

plugins {
    id("com.android.application")
    jacoco
    checkstyle
    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
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

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
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

    lintOptions.isAbortOnError = false
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

    testImplementation(Libs.Test.JUNIT_API)
    testImplementation(Libs.Test.JUNIT_ENG)
    testImplementation(Libs.Test.Kotlin.MOCK_K) {
        because("we want to learn about this library")
    }
    testImplementation(Libs.Test.OkHttp3.MOCKWEBSERVER)
    testImplementation(Libs.Test.AndroidX.CORE_TESTING)

    androidTestImplementation(Libs.Test.JUNIT_EXT)
}

tasks.withType<Test> {
    useJUnitPlatform()
    testLogging {
        events("passed", "skipped", "failed")
    }
}

/*

sonarqube {
    properties {
        property("sonar.projectKey", "josemlechon_breaking-bad")
        property("sonar.organization", "josemlechon")
        property("sonar.host.url", "https://sonarcloud.io")
        property("sonar.login", "288735357f3535f25d09ad55caf4176f07bdbff1")
        property("sonar.projectName", "Breaking Bad")
        property("sonar.jacoco.reportPaths", "build/jacoco/*.exec")
        property("sonar.androidLint.reportPaths", "build/reports/lint-results.xml")
        property("sonar.junit.reportsPaths", "build/test-results")
        property("sonar.coverage.jacoco.xmlReportPaths", "build/test-results/*Debug*/*.xml")
    }
}

 */
