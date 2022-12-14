package com.zanyx.advent

import java.io.InputStream
import java.io.InputStreamReader

class FindMessageStartMarker {

    operator fun invoke(stream: InputStream): Marker? {
        return stream.reader().use { reader ->
            val marker = mutableListOf<Char>()
            var readChars = 0
            var nextChar = reader.readChar()
            while (nextChar != null && marker.size != 14) {
                readChars += 1
                val charPosition = marker.indexOf(nextChar)
                if (charPosition != -1) {
                    for (i in 0..charPosition) {
                        marker.removeFirst()
                    }
                }
                marker.add(nextChar)
                nextChar = reader.readChar()
            }
            readChars.takeIf { marker.size == 14 }?.let {
                Marker(value = String(marker.toCharArray()), position = it)
            }
        }
    }
}

private fun InputStreamReader.readChar(): Char? =
    read().takeIf { it != -1 }?.toChar()
