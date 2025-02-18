package org.example.syntax

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ScopeFunctionsTest {
    @Test
    fun nullableLetReturnsLength() {
        val length = ScopeFunctions.nullableLet("Hello")
        Assertions.assertEquals(5, length)
    }

    @Test
    fun nullableLetReturnsDefaultWhenNull() {
        val length = ScopeFunctions.nullableLet(null)
        Assertions.assertEquals(0, length)
    }

    @Test
    fun notUsingLetUpdatesFan() {
        val fan = Fan("Jo", 11)
        val updatedFan = ScopeFunctions.notUsingLet()
        Assertions.assertEquals(fan.name, updatedFan.name)
        Assertions.assertEquals(fan.showsAttended, updatedFan.showsAttended)
    }

    @Test
    fun usingLetUpdatesFan() {
        val fan = Fan("Jo", 11)
        val updatedFan = ScopeFunctions.usingLet()
        Assertions.assertEquals(fan.name, updatedFan.name)
        Assertions.assertEquals(fan.showsAttended, updatedFan.showsAttended)
    }

    @Test
    fun notUsingWithUpdatesFan() {
        val fan = Fan("Jane", 31)
        Assertions.assertEquals(fan.name, ScopeFunctions.notUsingWith().name)
        Assertions.assertEquals(fan.showsAttended, ScopeFunctions.notUsingWith().showsAttended)
    }

    @Test
    fun usingWithUpdatesFan() {
        val fan = Fan("Jane", 31)
        Assertions.assertEquals(fan.name, ScopeFunctions.usingWith().name)
        Assertions.assertEquals(fan.showsAttended, ScopeFunctions.usingWith().showsAttended)
    }

    @Test
    fun usingRunUpdatesFan() {
        val fan = Fan("Bob", 0)
        val updatedFan = ScopeFunctions.usingRun()
        Assertions.assertEquals(fan.name, updatedFan.name)
        Assertions.assertEquals(fan.showsAttended, updatedFan.showsAttended)
    }

    @Test
    fun usingApplyUpdatesFan() {
        val fan = Fan("Jemma", 44)
        val updatedFan = ScopeFunctions.usingApply()
        Assertions.assertEquals(fan.name, updatedFan.name)
        Assertions.assertEquals(fan.showsAttended, updatedFan.showsAttended)
    }

    @Test
    fun usingAlsoUpdatesFans() {
        val fans = mutableListOf<Fan>(Fan("Bob", 0), Fan("Jemma", 44), Fan("Jill", 0))
        val updatedFans = ScopeFunctions.usingAlso()
        Assertions.assertEquals(fans, updatedFans)
    }
}