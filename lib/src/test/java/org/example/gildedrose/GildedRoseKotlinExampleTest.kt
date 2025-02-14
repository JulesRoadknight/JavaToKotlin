package org.example.gildedrose

import org.junit.jupiter.api.Assertions
import org.junit.jupiter.api.Test

internal class GildedRoseKotlinExampleTest {
    @Test
    fun itemsHaveProperties() {
        val items = arrayOf(Item("Nameynamerson", 0, 0))
        val app = GildedRoseKotlinExample(items)
        Assertions.assertEquals("Nameynamerson", app.items[0].name)
        Assertions.assertEquals(0, app.items[0].quality)
        Assertions.assertEquals(0, app.items[0].sellIn)
    }

    @Test
    fun qualityIsNotNegative() {
        val items = arrayOf(Item("Nameynamerson", 0, 0))
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(0, app.items[0].quality)
    }

    @Test
    fun qualityDegradesForNormalItems() {
        val items = arrayOf(Item("Nameynamerson", 2, 1))
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(0, app.items[0].quality)
    }

    @Test
    fun expiredItemsDegradeFaster() {
        val items = arrayOf(Item("Nameynamerson", 0, 10))
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(8, app.items[0].quality)
    }

    @Test
    fun agedBrieGetsBetterWithAge() {
        val items = arrayOf(Item("Aged Brie", 5, 10))
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(11, app.items[0].quality)
    }

    @Test
    fun agedBrieGetsEvenBetterWithAge() {
        val items = arrayOf(Item("Aged Brie", 0, 10))
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(12, app.items[0].quality)
    }

    @Test
    fun qualityDoesNotExceedFifty() {
        val items = arrayOf(
            Item("Aged Brie", 0, 49),
            Item("Aged Brie", 0, 50),
            Item("Backstage passes to a TAFKAL80ETC concert", 20, 49)
        )
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(50, app.items[0].quality)
        Assertions.assertEquals(50, app.items[1].quality)
        Assertions.assertEquals(50, app.items[2].quality)
    }

    @Test
    fun sulfurasIsConstant() {
        val items = arrayOf(Item("Sulfuras, Hand of Ragnaros", 5, 80))
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(80, app.items[0].quality)
    }

    @Test
    fun ticketsGetMoreValuableBeforeConcert() {
        val items = arrayOf(
            Item(
                "Backstage passes to a TAFKAL80ETC concert",
                20,
                30
            )
        )
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(31, app.items[0].quality)
    }

    @Test
    fun ticketsGetEvenMoreValuableBeforeConcert() {
        val items = arrayOf(
            Item(
                "Backstage passes to a TAFKAL80ETC concert",
                10,
                30
            )
        )
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(32, app.items[0].quality)
    }

    @Test
    fun ticketsAreMostValuableJustBeforeConcert() {
        val items = arrayOf(
            Item(
                "Backstage passes to a TAFKAL80ETC concert",
                5,
                30
            )
        )
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(33, app.items[0].quality)
    }

    @Test
    fun ticketsWorthlessAfterConcert() {
        val items = arrayOf(
            Item(
                "Backstage passes to a TAFKAL80ETC concert",
                0,
                30
            )
        )
        val app = GildedRoseKotlinExample(items)
        app.updateQuality()
        Assertions.assertEquals(0, app.items[0].quality)
    }
}