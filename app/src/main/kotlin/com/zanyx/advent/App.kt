package com.zanyx.advent

import java.io.File

fun main() {
    val findDuplicateItem = FindDuplicateItem()
    val getItemPriority = GetItemPriority()
    val duplicatePriorities = File("input.txt").readLines().map { rucksackItems ->
        getItemPriority(item = findDuplicateItem(rucksackItems))
    }
    println("${duplicatePriorities.sum()}")
}
