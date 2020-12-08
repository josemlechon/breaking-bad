buildscript {
    val kotlinVersion = "1.4.0"

    repositories {
        google()
        jcenter()
        maven("https://plugins.gradle.org/m2/")
    }
    dependencies {
        classpath("com.android.tools.build:gradle:4.2.0-beta01")
        classpath(kotlin("gradle-plugin", version = kotlinVersion))

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.3.2")
        //classpath("org.sonarsource.scanner.gradle:sonarqube-gradle-plugin:2.8")
    }
}

allprojects {
    repositories {
        google()
        jcenter()

        mavenCentral()
    }
}

subprojects {

    tasks.withType<Test>().configureEach {
        useJUnitPlatform()
    }
}
