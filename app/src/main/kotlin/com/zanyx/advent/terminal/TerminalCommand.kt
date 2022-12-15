package com.zanyx.advent.terminal

sealed interface TerminalCommand {

    data class ChangeDirectory(
        val path: String,
    ): TerminalCommand

    data class ListContent(
        val directories: List<Directory>,
        val files: List<File>,
    ) : TerminalCommand {

        data class Directory(val name: String)

        data class File(val name: String, val size: Long)
    }
}