package com.zanyx.advent.terminal

class CommandInvocationParser(private val commandParsers: List<CommandParser>) {

    fun parse(invocation: String): TerminalCommand? {
        if (!isCommand(invocation)) {
            throw IllegalArgumentException("$invocation is not a valid command")
        }
        return invocation.split(" ").let { tokens ->
            val alias = tokens[1]
            val arguments = tokens.getOrElse(2) { "" }

            commandParsers.first { it.alias == alias }.parseCommand(arguments)
        }
    }

    private fun isCommand(text: String): Boolean =
        text.startsWith("$")

    interface CommandParser {

        val alias: String

        fun parseCommand(arguments: String): TerminalCommand
    }
}