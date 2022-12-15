package com.zanyx.advent

data class Tree(
    val height: Int,
    val position: Position,
    var visibilityBlockedBy: Neighbours,
) {

     fun score(): Int {
        return (visibilityBlockedBy.left?.let { position.y - it.position.y } ?: 0) *
                (visibilityBlockedBy.top?.let { position.x - it.position.x } ?: 0) *
                (visibilityBlockedBy.right?.let { it.position.y - position.y } ?: 0) *
                (visibilityBlockedBy.bottom?.let { it.position.x - position.x } ?: 0)
    }

    override fun toString(): String {
        return "$height (l=${visibilityBlockedBy.left?.height}, t=${visibilityBlockedBy.top?.height}, r=${visibilityBlockedBy.right?.height}, b=${visibilityBlockedBy.bottom?.height})"
    }

    data class Position(val x: Int, val y: Int)
}

data class Neighbours(
    val left: Tree?,
    val top: Tree?,
    val right: Tree?,
    val bottom: Tree?
)