package com.zanyx.advent

class HasOverlappingSectors {

    operator fun invoke(assignment: Assignment): Boolean =
        assignment.sector1.contains(assignment.sector2) ||
            assignment.sector2.contains(assignment.sector1)

    private fun IntRange.contains(other: IntRange): Boolean =
        other.first >= start && other.last <= endInclusive
}