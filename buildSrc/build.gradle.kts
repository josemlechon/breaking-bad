plugins {
    kotlin("jvm") version "1.4.0"
}

repositories {
    mavenCentral()
    google()
    jcenter()
    maven {
        url = uri("https://plugins.gradle.org/m2/")
    }
}


dependencies {

    implementation("com.android.tools.build:gradle:4.2.0-beta01")
    implementation("org.jetbrains.kotlin:kotlin-gradle-plugin:1.4.0")

    implementation(gradleApi())
    implementation(localGroovy())

}
/*
dependencies {
    implementation("com.android.tools.build:gradle:4.0.0")
    implementation(kotlin("stdlib-jdk8"))
}
val compileKotlin: KotlinCompile by tasks
compileKotlin.kotlinOptions {
    jvmTarget = "1.8"
}
val compileTestKotlin: KotlinCompile by tasks
compileTestKotlin.kotlinOptions {
    jvmTarget = "1.8"
}*/