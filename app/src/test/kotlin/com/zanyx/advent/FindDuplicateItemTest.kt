package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertEquals

class FindDuplicateItemTest {

    private val findDuplicateItem = FindDuplicateItem()

    @Test fun `verify found duplicates`() {
        listOf(
            "vJrwpWtwJgWrhcsFMMfFFhFp" to 'p',
            "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL" to 'L',
            "PmmdzqPrVvPwwTWBwg" to 'P',
            "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn" to 'v',
            "ttgJtRGJQctTZtZT" to 't',
            "CrZsJsPPZsGzwwsLwLmpwMDw" to 's',
        ).forEach { (rucksackItems, duplicateItem) ->
            assertEquals(duplicateItem, findDuplicateItem(rucksackItems))
        }
    }
}