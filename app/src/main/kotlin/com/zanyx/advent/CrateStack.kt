package com.zanyx.advent

import java.util.ArrayDeque

class CrateStack(vararg elements: Char) {

    private val _elements = ArrayDeque(elements.asList())

    fun push(elements: List<Char>) {
        elements.forEach { _elements.push(it) }
    }

    fun pop(count: Int): List<Char> {
        return (0 until count).map { _elements.pop() }
    }

    fun top(): Char = _elements.peek()

    fun isEmpty(): Boolean = _elements.isEmpty()

    override fun hashCode(): Int {
        return _elements.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return _elements == (other as? CrateStack)?._elements
    }

    override fun toString(): String {
        return _elements.joinToString(separator = " ") { "[$it]" }
    }
}
