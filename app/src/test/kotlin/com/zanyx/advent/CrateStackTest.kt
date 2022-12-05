package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertContentEquals
import kotlin.test.assertTrue

class CrateStackTest {

    @Test fun `verify pop removes element`() {
        val crateStack = CrateStack('A')
        assertContentEquals(
            expected = listOf('A'),
            actual = crateStack.pop(1)
        )
        assertTrue(crateStack.isEmpty(), message = "Stack is not empty ($crateStack)")
    }

    @Test fun `verify elements order`() {
        val crateStack = CrateStack('A', 'B')
        assertContentEquals(
            expected = listOf('A', 'B'),
            actual = crateStack.pop(2)
        )
    }

    @Test fun `verify push elements order`() {
        val crateStack = CrateStack('B').also { it.push(listOf('A')) }
        assertContentEquals(
            expected = listOf('A', 'B'),
            actual = crateStack.pop(2)
        )
    }
}