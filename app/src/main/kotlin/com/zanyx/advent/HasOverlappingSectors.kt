package com.zanyx.advent

class HasOverlappingSectors {

    operator fun invoke(assignment: Assignment): Boolean =
        assignment.sector1.overlaps(assignment.sector2) ||
            assignment.sector2.overlaps(assignment.sector1)

    private fun IntRange.overlaps(other: IntRange): Boolean =
        start in other || last in other
}