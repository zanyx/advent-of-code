package com.zanyx.advent.terminal

import java.io.BufferedReader
import java.io.Closeable
import java.io.File

class Terminal(private val stream: BufferedReader) : Closeable by stream {

    private val parser = CommandInvocationParser(
        commandParsers = listOf(
            ChangeDirectoryCommandParser(),
            ListCommandParser(stream),
        )
    )

    constructor(input: File) : this(input.reader().buffered())

    fun nextCommand(): TerminalCommand? {
        return stream.takeIf { it.ready() }?.let { reader ->
            reader.readLine()?.let(parser::parse)
        }
    }
}