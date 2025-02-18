package org.example.syntax

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class WhenTest {
    @Test
    fun whatNumberReturnsMatch() {
        Assertions.assertEquals("One", When.whatNumber(1))
        Assertions.assertEquals("Getting higher", When.whatNumber(4))
        Assertions.assertEquals("Wow, big number", When.whatNumber(9))
        Assertions.assertEquals("Unknown", When.whatNumber(11))
    }

    @Test
    fun oddOeEvenReturns() {
        Assertions.assertEquals("Odd number", When.oddOrEven(3535353))
        Assertions.assertEquals("Even number", When.oddOrEven(11112))
    }
}