package com.zanyx.advent

class FindBadge {

    operator fun invoke(groupRucksackItems: List<String>): Char {
        return groupRucksackItems.map { it.asIterable() }
            .reduce { acc, s -> acc.intersect(s.toSet()) }
            .first()
    }
}