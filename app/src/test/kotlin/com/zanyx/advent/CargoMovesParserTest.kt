package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertContentEquals

class CargoMovesParserTest {

    @Test
    fun `verify moves parsing`() {
        assertContentEquals(
            expected = listOf(
                CargoMove(
                    moveElementsCount = 1,
                    sourceStack = 2,
                    destinationStack = 1
                )
            ),
            actual = CargoMovesParser.parse(listOf("move 1 from 2 to 1"))
        )
    }
}