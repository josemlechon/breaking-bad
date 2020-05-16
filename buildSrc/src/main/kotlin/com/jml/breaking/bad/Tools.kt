package com.jml.breaking.bad

import com.android.build.gradle.*
import com.android.build.gradle.internal.dsl.BaseAppModuleExtension
import org.gradle.api.NamedDomainObjectContainer
import org.gradle.api.Project
import org.gradle.api.plugins.BasePlugin
import org.gradle.kotlin.dsl.getByType

fun Project.applyKotlinFoldersInModules() {
    plugins.matching { it is AppPlugin || it is LibraryPlugin }
        .whenPluginAdded {

            if (this is BasePlugin) {
                project.extensions
                    .getByType<BaseExtension>()
                    .apply {
                        sourceSets.forEach {
                            it.java.srcDir("src/${it.name}/kotlin")
                        }
                    }
            }
        }
}

fun BaseAppModuleExtension.applyKotlinFolders(){

    sourceSets.forEach {
        it.java.srcDir("src/${it.name}/kotlin")
    }
}

fun <T> NamedDomainObjectContainer<T>.release(configure: T.() -> Unit) = getByName("release", configure)
fun <T> NamedDomainObjectContainer<T>.debug(configure: T.() -> Unit) = getByName("debug", configure)
fun <T> NamedDomainObjectContainer<T>.all(configure: T.() -> Unit) = getByName("all", configure)

