package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertEquals

class GameTest {

    @Test fun `verify game score`() {
        val game = Game(
            rounds = listOf(
                Round(expectedResult = RoundResult.Draw, opponentShape = HandShape.Rock),
                Round(expectedResult = RoundResult.Lose, opponentShape = HandShape.Paper),
                Round(expectedResult = RoundResult.Win, opponentShape = HandShape.Scissor),
            )
        )
        assertEquals(12, game.resolve(), "Unexpected game score")
    }
}