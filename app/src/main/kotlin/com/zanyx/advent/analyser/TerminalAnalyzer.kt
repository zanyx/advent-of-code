package com.zanyx.advent.analyser

import com.zanyx.advent.Directory
import com.zanyx.advent.FileSystemStructure
import com.zanyx.advent.terminal.Terminal
import com.zanyx.advent.terminal.TerminalCommand

class TerminalAnalyzer(
    private val terminal: Terminal
) {

    private val changeDirectoryAnalyzer = ChangeDirectoryAnalyzer()
    private val listContentAnalyzer = ListContentAnalyzer()

    fun discoverFileSystemStructure(): FileSystemStructure {
        return terminal.use {
            val context = DiscoveryContext(
                path = Path(),
                directories = mutableMapOf(
                    Path.Root to Directory(
                        parentDir = null,
                        name = "/",
                        size = 0L
                    )
                ),
                files = mutableListOf()
            )
            var nextCommand = it.nextCommand()
            while (nextCommand != null) {
                analyzeCommand(context, nextCommand)
                nextCommand = it.nextCommand()
            }
            FileSystemStructure(
                root = context.directories.getValue(Path.Root),
                directories = context.directories.values.toList(),
                files = context.files
            )
        }
    }

    private fun analyzeCommand(
        context: DiscoveryContext,
        command: TerminalCommand
    ) {
        when (command) {
            is TerminalCommand.ChangeDirectory -> {
                changeDirectoryAnalyzer.analyze(context, command)
            }

            is TerminalCommand.ListContent -> {
                listContentAnalyzer.analyze(context, command)
            }
        }
    }
}