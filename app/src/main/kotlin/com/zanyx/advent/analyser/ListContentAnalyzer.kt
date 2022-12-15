package com.zanyx.advent.analyser

import com.zanyx.advent.Directory
import com.zanyx.advent.File
import com.zanyx.advent.terminal.TerminalCommand

class ListContentAnalyzer {

    fun analyze(context: DiscoveryContext, command: TerminalCommand.ListContent) {
        command.directories.forEach { directory ->
            context.directories.putIfAbsent(
                    Path(context.path, directory.name),
                    Directory(
                        parentDir = context.directories[context.path],
                        name = directory.name,
                        size = 0L
                    )
                )
        }

        var filesSize = 0L
        command.files.forEach { file ->
            context.files.add(
                File(
                    parentDir = context.directories[context.path],
                    name = file.name,
                    size = file.size
                )
            )
            filesSize += file.size
        }

        context.directories[context.path]?.let { parentDir ->
            updateDirSize(parentDir, filesSize)
        }
    }

    private fun updateDirSize(dir: Directory, size: Long) {
        dir.size += size
        dir.parentDir?.let { updateDirSize(it, size) }
    }
}