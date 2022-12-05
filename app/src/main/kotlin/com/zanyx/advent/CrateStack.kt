package com.zanyx.advent

class CrateStack(vararg elements: Char) {

    private val _elements: MutableList<Char> = elements.toMutableList()

    fun push(vararg elements: Char) {
        _elements.addAll(0, elements.asList())
    }

    fun pop(): Char {
        return _elements.removeFirstOrNull()
            ?: throw IllegalStateException("Stack is empty")
    }

    fun top(): Char = _elements.first()

    fun isEmpty(): Boolean = _elements.isEmpty()

    override fun hashCode(): Int {
        return _elements.hashCode()
    }

    override fun equals(other: Any?): Boolean {
        return _elements == (other as? CrateStack)?._elements
    }

    override fun toString(): String {
        return _elements.asReversed().joinToString(separator = " ") { "[$it]" }
    }
}
