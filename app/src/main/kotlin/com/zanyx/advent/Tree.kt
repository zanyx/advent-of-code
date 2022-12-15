package com.zanyx.advent

data class Tree(
    val height: Int,
    var tallestNeighbours: TallestNeighbours,
) {

    fun tallest(other: Tree?): Tree =
        other?.takeIf { it.height > height } ?: this

    fun isVisible(): Boolean =
        tallestNeighbours.left?.takeIf { it.height >= height } == null
                || tallestNeighbours.top?.takeIf { it.height >= height } == null
                || tallestNeighbours.right?.takeIf { it.height >= height } == null
                || tallestNeighbours.bottom?.takeIf { it.height >= height } == null

    override fun toString(): String {
        return "$height (l=${tallestNeighbours.left?.height}, t=${tallestNeighbours.top?.height}, r=${tallestNeighbours.right?.height}, b=${tallestNeighbours.bottom?.height})"
    }
}

data class TallestNeighbours(
    val left: Tree?,
    val top: Tree?,
    val right: Tree?,
    val bottom: Tree?
)