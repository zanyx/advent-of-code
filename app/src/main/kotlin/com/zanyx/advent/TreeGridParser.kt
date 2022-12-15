package com.zanyx.advent

import java.io.InputStream

object TreeGridParser {

    fun parse(input: InputStream): List<List<Tree>> {
        val treeGrid = mutableListOf<List<Tree>>()
        input.reader().use { reader ->
            reader.readLines().forEachIndexed { row, line ->
                val rowList = mutableListOf<Tree>()
                line.forEachIndexed { col, charHeight ->
                    val height = charHeight.digitToInt()
                    val leftCoveringTree = if (col == 0) {
                        null
                    } else {
                        rowList.slice(0 until col).lastOrNull { it.height >= height }
                            ?: rowList.first()
                    }
                    val topCoveringTree = if (row == 0) {
                        null
                    } else {
                        (0 until row).map { treeGrid[it][col] }.lastOrNull {  it.height >= height }
                            ?: treeGrid[0][col]
                    }

                    rowList.add(
                        Tree(
                            height,
                            position = Tree.Position(x = row, y = col),
                            visibilityBlockedBy = Neighbours(
                                left = leftCoveringTree,
                                top = topCoveringTree,
                                right = null,
                                bottom = null,
                            )
                        )
                    )
                }
                treeGrid.add(rowList)
            }
        }

        for (row in treeGrid.indices.reversed()) {
            val treeRow = treeGrid[row]
            for (col in treeRow.indices.reversed()) {
                treeRow[col].apply {
                    val rightCoveringTree = if (col == treeRow.lastIndex) {
                        null
                    } else {
                        treeRow.slice((col + 1)..treeRow.lastIndex).firstOrNull {
                            it.height >= height
                        } ?: treeRow.last()
                    }
                    val bottomCoveringTree = if (row == treeGrid.lastIndex) {
                        null
                    } else {
                        ((row + 1)..treeGrid.lastIndex).map { treeGrid[it][col] }.firstOrNull {
                            it.height >= height
                        } ?: treeGrid.last()[col]
                    }

                    visibilityBlockedBy = visibilityBlockedBy.copy(
                        right = rightCoveringTree,
                        bottom = bottomCoveringTree,
                    )
                }
            }
        }
        return treeGrid
    }
}