package com.zanyx.advent

object InputRulesParser {

    fun parse(input: List<String>): InputRules {
        return InputRules(
            crateStacks = CrateStacksParser.parse(input.takeWhile { it.isNotBlank() }),
            cargoMoves = CargoMovesParser.parse(input.takeLastWhile { it.isNotBlank() }),
        )
    }
}