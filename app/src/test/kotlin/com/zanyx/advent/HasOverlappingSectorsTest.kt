package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertTrue

class HasOverlappingSectorsTest {

    private val hasOverlappingSectors = HasOverlappingSectors()

    @Test fun `verify sectors overlapping are found`() {
        listOf(
            Assignment(sector1 = 2..8, sector2 = 3..7),
            Assignment(sector1 = 4..6, sector2 = 6..6),
            Assignment(sector1 = 5..7, sector2 = 7..9),
            Assignment(sector1 = 2..6, sector2 = 4..8),
        ).forEach { assignment ->
            assertTrue(hasOverlappingSectors(assignment))
        }
    }
}