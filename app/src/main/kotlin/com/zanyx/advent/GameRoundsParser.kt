package com.zanyx.advent

object GameRoundsParser {

    fun parse(input: List<String>): List<Round> {
        return input.map {
            val (opponentMove, playerMove) = it.split(" ")
            Round(
                playerShape = when (playerMove) {
                    "X" -> HandShape.Rock
                    "Y" -> HandShape.Paper
                    "Z" -> HandShape.Scissor
                    else -> throw IllegalArgumentException("Unknown player move $playerMove")
                },
                opponentShape = when (opponentMove) {
                    "A" -> HandShape.Rock
                    "B" -> HandShape.Paper
                    "C" -> HandShape.Scissor
                    else -> throw IllegalArgumentException("Unknown opponent move $opponentMove")
                }
            )
        }
    }
}