package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertTrue

class CrateStackTest {

    @Test fun `verify pop removes element`() {
        val crateStack = CrateStack('A')
        assertEquals('A', crateStack.pop())
        assertTrue(crateStack.isEmpty())
    }

    @Test fun `verify elements order`() {
        val crateStack = CrateStack('A', 'B')
        assertEquals('A', crateStack.pop())
        assertEquals('B', crateStack.pop())
    }

    @Test fun `verify push elements order`() {
        val crateStack = CrateStack('B').also { it.push('A') }
        assertEquals('A', crateStack.pop())
        assertEquals('B', crateStack.pop())
    }
}