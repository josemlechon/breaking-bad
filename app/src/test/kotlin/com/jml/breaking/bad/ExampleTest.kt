package com.jml.breaking.bad

import kotlinx.coroutines.runBlocking
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test

internal class ExampleTest {

    @Test
    fun `let's try if this works finally`() = runBlocking {

        val example = Example()

        assertTrue(example.doSomething())
    }


    @Test
    fun `this one fails`() = runBlocking {

        val example = Example()

        assertTrue(example.doSomething())
    }
}

