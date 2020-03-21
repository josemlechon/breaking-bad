buildscript {
    val kotlinVersion = "1.3.61"

    repositories {
        jcenter()
        google()
    }
    dependencies {
        classpath("com.android.tools.build:gradle:3.6.1")
        classpath(kotlin("gradle-plugin", version = kotlinVersion ))

        classpath("androidx.navigation:navigation-safe-args-gradle-plugin:2.2.1")
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

tasks.register("clean").configure {
    delete("build")
}