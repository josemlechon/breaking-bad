

buildscript {
    val kotlinVersion = "1.3.61"

    repositories {
        jcenter()
        google()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.1")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.2.2")
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.8")

        classpath("com.dicedmelon.gradle:jacoco-android:0.1.4")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

        mavenCentral()
        maven("http://repository.jetbrains.com/all")
    }
}
/*
subprojects {
    apply { plugin("org.sonarqube") }


    sonarqube {
        properties {
            property "sonar.coverage.jacoco.xmlReportPaths", "$projectDir.parentFile.path/app/build/reports/jacoco/testDevDebugUnitTestCoverage/testDevDebugUnitTestCoverage.xml"
        }
    }
}

 */

tasks.register("clean").configure {
    delete("build")
}