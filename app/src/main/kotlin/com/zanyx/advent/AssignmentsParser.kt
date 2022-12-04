package com.zanyx.advent

object AssignmentsParser {

    fun parse(input: List<String>): List<Assignment> {
        return input.map { text ->
            val (sector1, sector2) = text.split(',')
            Assignment(sector1 = parseRange(sector1),sector2 = parseRange(sector2))
        }
    }

    private fun parseRange(text: String): IntRange {
        val (start, end) = text.split('-')
        return start.toInt()..end.toInt()
    }
}