package com.zanyx.advent

class Game(private val rounds: List<Round>) {

    fun resolve(): Int {
        return rounds.sumOf { round ->
            val resultScore = roundResult(round).let {
                when (it) {
                    RoundResult.Win -> 6
                    RoundResult.Lost -> 0
                    RoundResult.Draw -> 3
                }
            }
            val shapeScore =
                when (round.playerShape) {
                    HandShape.Rock -> 1
                    HandShape.Paper -> 2
                    HandShape.Scissor -> 3
                }
            shapeScore + resultScore
        }
    }

    private fun roundResult(round: Round): RoundResult {
        return with(round) {
            when {
                (playerShape == HandShape.Paper && opponentShape == HandShape.Rock) ||
                (playerShape == HandShape.Rock && opponentShape == HandShape.Scissor) ||
                (playerShape == HandShape.Scissor && opponentShape == HandShape.Paper) ->
                    RoundResult.Win
                (playerShape == HandShape.Paper && opponentShape == HandShape.Scissor) ||
                (playerShape == HandShape.Rock && opponentShape == HandShape.Paper) ||
                (playerShape == HandShape.Scissor && opponentShape == HandShape.Rock) ->
                    RoundResult.Lost
                else ->
                    RoundResult.Draw
            }
        }
    }

    private enum class RoundResult {
        Win,
        Lost,
        Draw,
    }
}