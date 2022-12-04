package com.zanyx.advent

class FindDuplicateItem {

    operator fun invoke(rucksackItems: String): Char {
        val (slot1, slot2) = rucksackItems.chunked(rucksackItems.length / 2)
        return slot1.first { slot2.contains(it) }
    }
}