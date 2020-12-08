package com.jml.breaking.bad.jacoco

import org.gradle.api.Action

open class JacocoExtension {
    open val options: JacocoOptions = JacocoOptions()
    open fun options(action: Action<JacocoOptions>) {
        action.execute(options)
    }
}

open class JacocoOptions {
    open var isEnabled: Boolean = true
    open var includeLocationClasses: Boolean = true
    open var excludes: MutableSet<String> = fileFilter
    open fun excludes(vararg excludes: String) {
        this.excludes.addAll(excludes)
    }
}

private val androidDataBindingExcludes = mutableSetOf(
    "android/databinding/**/*.class",
    "**/android/databinding/*Binding.class",
    "**/BR.*")
private val androidExcludes = mutableSetOf(
    "**/R.class",
    "**/R\$*.class",
    "**/BuildConfig.*",
    "**/Manifest*.*",
    "**/*Test*.*"
)
private val butterKnifeExcludes = mutableSetOf(
    "**/*\$ViewInjector*.*",
    "**/*\$ViewBinder*.*"
)
private val dagger2Excludes = mutableSetOf(
    "**/*_MembersInjector.class",
    "**/Dagger*Component.class",
    "**/Dagger*Component\$Builder.class",
    "**/*Module_*Factory.class")
private val otherExcludes = mutableSetOf(
    "android/**/*.*",
    "**/*\$Lambda$*.*",
    "**/*\$inlined$*.*"
)
private val fileFilter = (androidDataBindingExcludes + androidExcludes + butterKnifeExcludes + dagger2Excludes + otherExcludes).toMutableSet()