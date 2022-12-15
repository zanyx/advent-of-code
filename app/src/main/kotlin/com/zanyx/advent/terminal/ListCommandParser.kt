package com.zanyx.advent.terminal

import com.zanyx.advent.terminal.TerminalCommand.ListContent
import java.io.BufferedReader

class ListCommandParser(
    private val stream: BufferedReader
) : CommandInvocationParser.CommandParser {

    override val alias: String = "ls"

    override fun parseCommand(arguments: String): TerminalCommand {
        val directories = mutableListOf<ListContent.Directory>()
        val files = mutableListOf<ListContent.File>()
        var commandOutputEndReached = false

        stream.mark(DEFAULT_BUFFER_SIZE)
        do {
            stream.readLine()?.let { nextLine ->
                when {
                    nextLine.startsWith("$") -> {
                        stream.reset()
                        commandOutputEndReached = true
                    }

                    nextLine.startsWith("dir") -> {
                        directories.add(
                            ListContent.Directory(
                                name = nextLine.split(" ").last()
                            )
                        )
                        stream.mark(DEFAULT_BUFFER_SIZE)
                    }

                    else -> {
                        val (size, name) = nextLine.split(" ")
                        files.add(ListContent.File(name, size.toLong()))
                        stream.mark(DEFAULT_BUFFER_SIZE)
                    }
                }
            } ?: run { commandOutputEndReached = true }
        } while (!commandOutputEndReached)
        return ListContent(directories, files)
    }
}