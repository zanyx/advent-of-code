package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertEquals

class GameTest {

    @Test fun `verify game score`() {
        val game = Game(
            rounds = listOf(
                Round(playerShape = HandShape.Paper, opponentShape = HandShape.Rock),
                Round(playerShape = HandShape.Rock, opponentShape = HandShape.Paper),
                Round(playerShape = HandShape.Scissor, opponentShape = HandShape.Scissor),
            )
        )
        assertEquals(15, game.resolve(), "Unexpected game score")
    }
}