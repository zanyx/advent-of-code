package com.zanyx.advent.analyser

import com.zanyx.advent.terminal.TerminalCommand

class ChangeDirectoryAnalyzer {

    fun analyze(context: DiscoveryContext, command: TerminalCommand.ChangeDirectory) {
        with (context.path) {
            when (command.path) {
                "/" -> root()

                ".." -> back()

                else -> append(command.path)
            }
        }
    }
}