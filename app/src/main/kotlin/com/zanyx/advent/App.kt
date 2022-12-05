package com.zanyx.advent

import java.io.File

fun main() {
    val (crateStacks, cargoMoves) = InputRulesParser.parse(File("input.txt").readLines())
    cargoMoves.forEach { move ->
        for (i in 0 until move.moveElementsCount) {
            crateStacks[move.destinationStack - 1].push(crateStacks[move.sourceStack - 1].pop())
        }
    }
    println(crateStacks.map { it.top() }.joinToString(separator = ""))
}
