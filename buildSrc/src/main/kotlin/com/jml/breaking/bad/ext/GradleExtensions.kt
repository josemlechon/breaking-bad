package com.jml.breaking.bad.ext

import org.gradle.api.NamedDomainObjectContainer

fun <T> NamedDomainObjectContainer<T>.release(configure: T.() -> Unit) = getByName("release", configure)
fun <T> NamedDomainObjectContainer<T>.debug(configure: T.() -> Unit) = getByName("debug", configure)
fun <T> NamedDomainObjectContainer<T>.all(configure: T.() -> Unit) = getByName("all", configure)