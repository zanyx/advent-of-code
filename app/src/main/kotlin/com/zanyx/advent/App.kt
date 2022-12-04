package com.zanyx.advent

import java.io.File

fun main() {
    val hasOverlappingSectors = HasOverlappingSectors()
    val overlappingAssignmentsCount = AssignmentsParser.parse(File("input.txt").readLines())
        .count { hasOverlappingSectors(it) }
    println(overlappingAssignmentsCount)
}
