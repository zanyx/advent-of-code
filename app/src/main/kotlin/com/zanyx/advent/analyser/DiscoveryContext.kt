package com.zanyx.advent.analyser

import com.zanyx.advent.Directory
import com.zanyx.advent.File

class DiscoveryContext(
    val path: Path,
    val directories: MutableMap<Path, Directory>,
    val files: MutableList<File>,
)