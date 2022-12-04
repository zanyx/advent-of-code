package com.zanyx.advent

class Game(private val rounds: List<Round>) {

    fun resolve(): Int {
        return rounds.sumOf { round ->
            val resultScore =
                when (round.expectedResult) {
                    RoundResult.Win -> 6
                    RoundResult.Lose -> 0
                    RoundResult.Draw -> 3
                }
            val shapeScore =
                when (playerShape(round)) {
                    HandShape.Rock -> 1
                    HandShape.Paper -> 2
                    HandShape.Scissor -> 3
                }
            shapeScore + resultScore
        }
    }

    private fun playerShape(round: Round): HandShape {
        return when (round.expectedResult) {
            RoundResult.Win ->
                when (round.opponentShape) {
                    HandShape.Paper -> HandShape.Scissor
                    HandShape.Rock -> HandShape.Paper
                    HandShape.Scissor -> HandShape.Rock
                }
            RoundResult.Lose ->
                when (round.opponentShape) {
                    HandShape.Paper -> HandShape.Rock
                    HandShape.Rock -> HandShape.Scissor
                    HandShape.Scissor -> HandShape.Paper
                }
            RoundResult.Draw -> round.opponentShape
        }
    }
}