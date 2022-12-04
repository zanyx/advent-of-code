package com.zanyx.advent

class GetItemPriority {

    private val prioritiesMap = ('a'..'z').mapIndexed { index, c -> c to (index + 1) }.toMap()

    operator fun invoke(item: Char): Int {
        return if (item.isUpperCase()) {
            prioritiesMap.getValue(item.lowercaseChar()) + 26
        } else {
            prioritiesMap.getValue(item)
        }
    }
}