package com.zanyx.advent

import java.io.File

fun main() {
    val (crateStacks, cargoMoves) = InputRulesParser.parse(File("input.txt").readLines())
    cargoMoves.forEach { move ->
        val cratesToMove = crateStacks[move.sourceStack - 1].pop(move.moveElementsCount)
        crateStacks[move.destinationStack - 1].push(cratesToMove)
    }
    println(crateStacks.map { it.top() }.joinToString(separator = ""))
}
