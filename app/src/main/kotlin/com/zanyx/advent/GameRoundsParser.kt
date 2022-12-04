package com.zanyx.advent

object GameRoundsParser {

    fun parse(input: List<String>): List<Round> {
        return input.map {
            val (opponentMove, roundResult) = it.split(" ")
            Round(
                opponentShape = when (opponentMove) {
                    "A" -> HandShape.Rock
                    "B" -> HandShape.Paper
                    "C" -> HandShape.Scissor
                    else -> throw IllegalArgumentException("Unknown opponent move $opponentMove")
                },
                expectedResult = when (roundResult) {
                    "X" -> RoundResult.Lose
                    "Y" -> RoundResult.Draw
                    "Z" -> RoundResult.Win
                    else -> throw IllegalArgumentException("Unknown round result $roundResult")
                },
            )
        }
    }
}