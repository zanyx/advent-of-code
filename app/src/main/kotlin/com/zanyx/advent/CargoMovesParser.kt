package com.zanyx.advent

object CargoMovesParser {

    fun parse(input: List<String>): List<CargoMove> {
        return input.map { line ->
            Regex("""move (\d+) from (\d+) to (\d+)""").find(line)?.let { match ->
                CargoMove(
                    moveElementsCount = match.groupValues[1].toInt(),
                    sourceStack = match.groupValues[2].toInt(),
                    destinationStack = match.groupValues[3].toInt(),
                )
            } ?: throw IllegalArgumentException("Failed to parse move from line \'$line\'")
        }
    }
}