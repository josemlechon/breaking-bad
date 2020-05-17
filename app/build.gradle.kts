import com.jml.breaking.bad.*
import com.jml.breaking.bad.applyKotlinFolders
import de.mannodermaus.gradle.plugins.junit5.junitPlatform
import org.jetbrains.kotlin.gradle.tasks.KotlinCompile


plugins {
    id("com.android.application")
    jacoco
    id("de.mannodermaus.android-junit5")
    checkstyle

    kotlin("android")
    kotlin("android.extensions")
    kotlin("kapt")
    id("androidx.navigation.safeargs.kotlin")
}

tasks.withType(KotlinCompile::class)
    .configureEach {
        kotlinOptions {
            jvmTarget = JavaVersion.VERSION_1_8.toString()
        }
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

    applyKotlinFolders()

    lintOptions.isAbortOnError = false

    testOptions {
        junitPlatform {
            filters {
                // These patterns follow the same format as Gradle's include() API.
                // For example, include all classes containing "Test" or "Tests" in their name,
                // and exclude those containing "Ignored".
                // More info in the Gradle docs:
                // https://docs.gradle.org/current/dsl/org.gradle.api.tasks.testing.Test.html#org.gradle.api.tasks.testing.Test:include(java.lang.String%5B%5D)
                includePattern("**/*Tests?*")
                excludePattern("**/*Ignored*")

                // Include all test classes tagged with @Tag("slow"), but exclude those annotated with @Tag("integration")
                includeTags("slow")
                excludeTags("integration")

            }
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


jacoco {
    toolVersion = "0.8.5"
    reportsDir = file("${project.projectDir}/app/build/reports")
}
