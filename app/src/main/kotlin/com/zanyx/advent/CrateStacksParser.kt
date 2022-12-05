package com.zanyx.advent

object CrateStacksParser {

    fun parse(input: List<String>): List<CrateStack> {
        val positions = input.last().let { line ->
            Regex(""" (\d+) """).findAll(line)
                .map { it.range to (it.groupValues[1].toInt() - 1) }
                .toMap()
        }
        return List(positions.count()) { CrateStack() }.also { stacks ->
            input.asReversed().drop(1).forEach { line ->
                Regex("""\[([A-Z]+)]""").findAll(line).forEach { match ->
                    stacks[positions.getValue(match.range)].push(match.groupValues[1].first())
                }
            }
        }
    }
}