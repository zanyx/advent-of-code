package com.zanyx.advent

import com.zanyx.advent.terminal.TerminalCommand.ListContent
import com.zanyx.advent.terminal.ListCommandParser
import kotlin.test.Test
import kotlin.test.assertEquals

internal class ListCommandParserTest {

    @Test fun `verify ls parsing`() {
        val content = """
            dir cmvqf
            dir dcgbjvj
            57426 gszshjwr.lrs
            dir nsgms
            124423 rjqns.prb
            dir wqvv
            $ cd cmvqf
        """.trimIndent()
        val streamReader = content.byteInputStream().bufferedReader()
        val parser = ListCommandParser(streamReader)
        assertEquals(
            ListContent(
                directories = listOf(
                    ListContent.Directory("cmvqf"),
                    ListContent.Directory("dcgbjvj"),
                    ListContent.Directory("nsgms"),
                    ListContent.Directory("wqvv"),
                ),
                files = listOf(
                    ListContent.File(name = "gszshjwr.lrs", size = 57426),
                    ListContent.File(name = "rjqns.prb", size = 124423),
                )
            ),
            parser.parseCommand("")
        )
        assertEquals(
            "$ cd cmvqf",
            streamReader.readLine(),
        )
    }

    @Test fun `verify ls parsing on empty output`() {
        val content = """
            $ cd cmvqf
        """.trimIndent()
        val streamReader = content.byteInputStream().bufferedReader()
        val parser = ListCommandParser(streamReader)
        assertEquals(
            ListContent(
                directories = emptyList(),
                files = emptyList()
            ),
            parser.parseCommand("")
        )
        assertEquals(
            "$ cd cmvqf",
            streamReader.readLine(),
        )
    }
}