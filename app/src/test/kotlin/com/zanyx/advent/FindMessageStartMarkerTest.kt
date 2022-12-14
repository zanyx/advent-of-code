package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertEquals

class FindMessageStartMarkerTest {

    private val findMessageStartMarker = FindMessageStartMarker()

    @Test fun `verify marker position when available in the stream`() {
        listOf(
            "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to Marker("qmgbljsphdztnv", 19),
            "bvwbjplbgvbhsrlpgdmjqwftvncz" to Marker("vbhsrlpgdmjqwf", 23),
            "nppdvjthqldpwncqszvftbrmjlhg" to Marker("ldpwncqszvftbr", 23),
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to Marker("wmzdfjlvtqnbhc", 29),
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to Marker("jwzlrfnpqdbhtm", 26),
        ).forEach { (input, expectedMarker) ->
            assertEquals(
                expectedMarker,
                findMessageStartMarker(input.byteInputStream())
            )
        }
    }
}