package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertEquals

class FindBadgeTest {

    private val findBadge = FindBadge()

    @Test fun `verify group badge`() {
        listOf(
            listOf(
                "vJrwpWtwJgWrhcsFMMfFFhFp",
                "jqHRNqRjqzjGDLGLrsFMfFZSrLrFZsSL",
                "PmmdzqPrVvPwwTWBwg",
            ) to 'r',
            listOf(
                "wMqvLMZHhHMvwLHjbvcjnnSBnvTQFn",
                "ttgJtRGJQctTZtZT",
                "CrZsJsPPZsGzwwsLwLmpwMDw",
            ) to 'Z',
        ).forEach { (groupRucksacks, expectedBadge) ->
            assertEquals(expectedBadge, findBadge(groupRucksacks))
        }
    }
}