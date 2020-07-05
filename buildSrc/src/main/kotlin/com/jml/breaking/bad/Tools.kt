package com.jml.breaking.bad

import org.gradle.api.NamedDomainObjectContainer


fun <T> NamedDomainObjectContainer<T>.release(configure: T.() -> Unit): T = getByName("release", configure)
fun <T> NamedDomainObjectContainer<T>.debug(configure: T.() -> Unit): T = getByName("debug", configure)
fun <T> NamedDomainObjectContainer<T>.all(configure: T.() -> Unit): T = getByName("all", configure)
