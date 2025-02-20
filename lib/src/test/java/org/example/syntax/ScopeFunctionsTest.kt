package org.example.syntax

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class ScopeFunctionsTest {
    @Test
    fun notUsingLetUpdatesFan() {
        val fanDataClass = FanDataClass("Jo", 11)
        val updatedFan = ScopeFunctions.notUsingLet()
        Assertions.assertEquals(fanDataClass.name, updatedFan.first)
        Assertions.assertEquals(fanDataClass.showsAttended, updatedFan.second)
    }

    @Test
    fun usingLetUpdatesFan() {
        val fanDataClass = FanDataClass("Jo", 11)
        val updatedFan = ScopeFunctions.usingLet().first
        Assertions.assertEquals(fanDataClass.name, updatedFan.name)
        Assertions.assertEquals(fanDataClass.showsAttended, updatedFan.showsAttended)
    }

    @Test
    fun notUsingWithUpdatesFan() {
        val fanDataClass = FanDataClass("Jane", 31)
        Assertions.assertEquals(fanDataClass.name, ScopeFunctions.notUsingWith().name)
        Assertions.assertEquals(fanDataClass.showsAttended, ScopeFunctions.notUsingWith().showsAttended)
    }

    @Test
    fun usingWithUpdatesFan() {
        val fanDataClass = FanDataClass("Jane", 31)
        Assertions.assertEquals(fanDataClass.name, ScopeFunctions.usingWith().name)
        Assertions.assertEquals(fanDataClass.showsAttended, ScopeFunctions.usingWith().showsAttended)
    }

    @Test
    fun usingRunUpdatesFan() {
        val fanDataClass = FanDataClass("Bob", 0)
        val updatedFan = ScopeFunctions.usingRun()
        Assertions.assertEquals(fanDataClass.name, updatedFan.name)
        Assertions.assertEquals(fanDataClass.showsAttended, updatedFan.showsAttended)
    }

    @Test
    fun usingApplyUpdatesFan() {
        val fanDataClass = FanDataClass("Jemma", 44)
        val updatedFan = ScopeFunctions.usingApply()
        Assertions.assertEquals(fanDataClass.name, updatedFan.name)
        Assertions.assertEquals(fanDataClass.showsAttended, updatedFan.showsAttended)
    }

    @Test
    fun usingAlsoUpdatesFans() {
        val fanDataClasses = mutableListOf<FanDataClass>(FanDataClass("Bob", 0), FanDataClass("Jemma", 44), FanDataClass("Jill", 0))
        val updatedFans = ScopeFunctions.usingAlso()
        Assertions.assertEquals(fanDataClasses, updatedFans)
    }
}