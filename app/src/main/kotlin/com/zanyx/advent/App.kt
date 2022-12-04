package com.zanyx.advent

import java.io.File

fun main() {
    val elfsCalories = ElfsCaloriesParser.parse(File("input.txt").readLines())
    println(elfsCalories.sortedDescending().take(3).sum())
}
