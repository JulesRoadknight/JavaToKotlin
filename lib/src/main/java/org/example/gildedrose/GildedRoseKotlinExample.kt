package org.example.gildedrose

class GildedRoseKotlinExample(var items: Array<Item>) {
    fun updateQuality() {
        for (item in items) {
            if (item.name == "Aged Brie") {
                updateAgedBrie(item)
            } else if (item.name == "Sulfuras, Hand of Ragnaros") {
                break
            } else if (item.name == "Backstage passes to a TAFKAL80ETC concert") {
                updateConcertTickets(item)
            } else {
                updateNormalItem(item)
            }
        }
    }

    private fun updateNormalItem(item: Item) {
        if (item.quality > 0) {
            item.quality -= 1
        }
        if (item.sellIn < 1 && item.quality > 0) {
            item.quality -= 1
        }
    }

    private fun updateConcertTickets(item: Item) {
        if (item.sellIn < 1) {
            item.quality = 0
            return
        }
        if (item.sellIn > 0 && item.quality < 50) {
            item.quality += 1
            if (item.sellIn <= 10) {
                if (item.sellIn <= 5) {
                    item.quality += 2
                } else {
                    item.quality += 1
                }
            }
        }
    }

    private fun updateAgedBrie(item: Item) {
        if (item.quality < 50) {
            item.quality += 1
            if (item.sellIn < 1 && item.quality < 50) {
                item.quality += 1
            }
        }
    }
}