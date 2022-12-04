package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertContentEquals

class ElfsCaloriesParserTest {

    @Test
    fun `verify parse with empty lines`() {
        assertContentEquals(ElfsCaloriesParser.parse(emptyList()), emptyList())
    }

    @Test
    fun `verify parse with single elf calories`() {
        listOf(
            listOf("1") to listOf(1L),
            listOf("1", "2") to listOf(3L),
            listOf("1", "2", "") to listOf(3L),
            listOf("1", "2", "", "3", "4") to listOf(3L, 7L),
        ).forEach { (input, expectedResult) ->
            val result = ElfsCaloriesParser.parse(input)
            assertContentEquals(result, expectedResult, "Expected $expectedResult, actual $result")
        }
    }
}