package org.example.syntax

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class NullabilityTest {
    @Test
    fun nullableLetReturnsLength() {
        val nullability = Nullability()
        val expected = "Default"

        val firstResponse = nullability.nullSafeOperatorWithoutElvis(null)
        val secondResponse = nullability.elvisOperator(null)
        val thirdResponse = nullability.assertNotNullOperator("Default")

        Assertions.assertEquals(expected, firstResponse)
        Assertions.assertEquals(expected, secondResponse)
        Assertions.assertEquals(7, thirdResponse)
    }

    @Test
    fun nullableLetHandlesNullValues() {
        val nullability = Nullability()

        val response = nullability.withLet(null)

        Assertions.assertEquals(0, response)
    }
}