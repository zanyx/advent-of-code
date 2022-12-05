package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertContentEquals

class CrateStacksParserTest {

    @Test fun `verify parsing`() {
        val input = """
                [D]    
            [N] [C]    
            [Z] [M] [P]
             1   2   3 
        """.trimIndent()
        val crateStacks = CrateStacksParser.parse(input.split("\n"))
        assertContentEquals(
            expected = listOf(
                CrateStack('Z', 'N'),
                CrateStack('M', 'C', 'D'),
                CrateStack('P'),
            ),
            actual = crateStacks
        )
    }
}