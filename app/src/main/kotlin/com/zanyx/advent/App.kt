package com.zanyx.advent

import java.io.File

fun main() {
    val getItemPriority = GetItemPriority()
    val findBadge = FindBadge()
    val badgePriorities = File("input.txt").readLines()
        .chunked(3)
        .map { groupRucksackItems ->
            val badge = findBadge(groupRucksackItems)
            getItemPriority(badge)
        }
    println("${badgePriorities.sum()}")
}
