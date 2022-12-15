package com.zanyx.advent

data class FileSystemStructure(
    val root: Directory,
    val directories: List<Directory>,
    val files: List<File>,
)

data class Directory(
    val parentDir: Directory?,
    val name: String,
    var size: Long,
)

data class File(
    val parentDir: Directory?,
    val name: String,
    val size: Long,
)