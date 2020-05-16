import com.jml.breaking.bad.applyKotlinFoldersInModules

buildscript {
    val kotlinVersion = "1.3.72"

    repositories {
        jcenter()
        google()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.3")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.2.2")
        classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.8")
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

subprojects {
    applyKotlinFoldersInModules()
}
