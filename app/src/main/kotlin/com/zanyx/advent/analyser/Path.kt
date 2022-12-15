package com.zanyx.advent.analyser

data class Path(
    private val segments: MutableList<String> = mutableListOf()
) {

    companion object {
        val Root = Path(segments = mutableListOf("/"))
    }

    constructor(parent: Path, path : String): this(
        parent.segments.toMutableList().also { it.add("/$path") }
    )

    fun root() {
        segments.clear()
        segments.add("/")
    }

    fun back() {
        segments.removeLast()
    }

    fun append(segment: String) {
        segments.add("/$segment")
    }

    override fun toString(): String {
        return segments.joinToString(separator = "")
    }
}