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
                    val leftTallestNeighbour = if (col == 0) {
                        null
                    } else {
                        val neighbour = rowList[col - 1]
                        neighbour.tallest(neighbour.tallestNeighbours.left)
                    }
                    val topTallestNeighbour = if (row == 0) {
                        null
                    } else {
                        val neighbour =  treeGrid[row - 1][col]
                        neighbour.tallest(neighbour.tallestNeighbours.top)
                    }

                    rowList.add(
                        Tree(
                            height,
                            TallestNeighbours(
                                left = leftTallestNeighbour,
                                top = topTallestNeighbour,
                                right = null,
                                bottom = null
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
                    val rightTallestNeighbour = if (col == treeRow.lastIndex) {
                        null
                    } else {
                        val neighbour = treeRow[col + 1]
                        neighbour.tallest(neighbour.tallestNeighbours.right)
                    }
                    val bottomTallestNeighbour = if (row == treeGrid.lastIndex) {
                        null
                    } else {
                        val neighbour = treeGrid[row + 1][col]
                        neighbour.tallest(neighbour.tallestNeighbours.bottom)
                    }

                    tallestNeighbours = tallestNeighbours.copy(
                        right = rightTallestNeighbour,
                        bottom = bottomTallestNeighbour,
                    )
                }
            }
        }
        return treeGrid
    }
}