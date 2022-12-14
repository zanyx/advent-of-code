package com.zanyx.advent

import kotlin.test.Test
import kotlin.test.assertEquals

class FindMessageStartMarkerTest {

    private val findMessageStartMarker = FindMessageStartMarker()

    @Test fun `verify marker position when available in the stream`() {
        listOf(
            "mjqjpqmgbljsphdztnvjfqwrcgsmlb" to Marker("jpqm", 7),
            "bvwbjplbgvbhsrlpgdmjqwftvncz" to Marker("vwbj", 5),
            "nppdvjthqldpwncqszvftbrmjlhg" to Marker("pdvj", 6),
            "nznrnfrfntjfmvfwmzdfjlvtqnbhcprsg" to Marker("rfnt", 10),
            "zcfzfwzzqfrljwzlrfnpqdbhtmscgvjw" to Marker("zqfr", 11),
        ).forEach { (input, expectedMarker) ->
            assertEquals(
                expectedMarker,
                findMessageStartMarker(input.byteInputStream())
            )
        }
    }
}