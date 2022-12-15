package com.zanyx.advent.terminal

class ChangeDirectoryCommandParser : CommandInvocationParser.CommandParser {

    override val alias: String = "cd"

    override fun parseCommand(arguments: String): TerminalCommand {
        return TerminalCommand.ChangeDirectory(path = arguments)
    }
}