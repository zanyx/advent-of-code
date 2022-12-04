package com.zanyx.advent

object ElfsCaloriesParser {

    fun parse(input: List<String>): List<Long> {
        return buildList {
            var calories = 0L
            input.forEach { line ->
                if (line.isEmpty()) {
                    add(calories)
                    calories = 0L
                } else {
                    calories += line.toLong()
                }
            }
            calories.takeIf { it > 0L }?.also { add(calories) }
        }
    }
}