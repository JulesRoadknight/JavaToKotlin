package org.example.syntax

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class FanDataClassTest {
    @Test
    fun getAndSetValues() {
        val fanBob = FanDataClass("Bob", 44)
        val fanName = fanBob.name
        fanBob.showsAttended = 0

        Assertions.assertEquals(0, fanBob.showsAttended)
    }

    @Test
    fun useCopy() {
        val fanBob = FanDataClass("Bob", 44)
        val imposterBob = fanBob.copy()

        Assertions.assertTrue(fanBob.equals(imposterBob))
    }

    @Test
    fun assertFansWithSameConstructorsAreEqual() {
        val fanBob = FanDataClass("Bob", 44)
        val imposterBob = fanBob.copy()

        imposterBob.interest = "baking"

        Assertions.assertEquals(fanBob, imposterBob)
        Assertions.assertNotEquals(fanBob.interest, imposterBob.interest)
    }

    @Test
    fun useHashcode() {
        val fanBob = FanDataClass("Bob", 44)
        val expectedHashCode = 66965

        Assertions.assertEquals(expectedHashCode, fanBob.name.hashCode())
    }

    @Test
    fun useEqualsAndHashcode() {
        val fanBob = FanDataClass("Bob", 44)
        val imposterBob = fanBob.copy()

        Assertions.assertTrue(fanBob.name.hashCode().equals(imposterBob.name.hashCode()))
        Assertions.assertTrue(fanBob.hashCode().equals(imposterBob.hashCode()))
    }

    @Test
    fun useToString() {
        val fanBob = FanDataClass("Bob", 44)
        val expected = "FanDataClass(name=Bob, showsAttended=44, isASuperFan=false)"

        Assertions.assertEquals(expected, fanBob.toString())
    }

    @Test
    fun useComponentN() {
        val fanBob = FanDataClass("Bob", 44)

        Assertions.assertEquals(fanBob.component1(), fanBob.name)
        Assertions.assertEquals(fanBob.component2(), fanBob.showsAttended)
    }

    @Test
    fun fanPairAndTriple() {
        val fanBob = FanDataClass("Bob", 44)
        val fanPair = Pair("Bob", 44)
        val fanTriple = Triple("Bob", 44, "Music")

        Assertions.assertEquals(fanPair, Pair(fanBob.name, fanBob.showsAttended))
        Assertions.assertEquals(fanTriple, Triple(fanBob.name, fanBob.showsAttended, fanBob.interest))
    }

    @Test
    fun destructureFan() {
        val fanBob = FanDataClass("Bob", 44)
        val (bobName, bobShowsAttended) = fanBob

        Assertions.assertEquals(fanBob.name, bobName)
        Assertions.assertEquals(fanBob.showsAttended, bobShowsAttended)
    }

    @Test
    fun destructureInLoop() {
        val fanBob = FanDataClass("Bob", 44)
        val fanJemma = FanDataClass("Jemma", 15)
        val fans = mutableListOf<FanDataClass>(fanBob, fanJemma)
        val newFans = mutableListOf<FanDataClass>()

        for ((a, b) in fans) {
            newFans.add(FanDataClass(a + a, b + b))
        }

        Assertions.assertEquals("FanDataClass(name=BobBob, showsAttended=88, isASuperFan=false)", newFans[0].toString())
        Assertions.assertEquals("FanDataClass(name=JemmaJemma, showsAttended=30, isASuperFan=false)", newFans[1].toString())
    }
}