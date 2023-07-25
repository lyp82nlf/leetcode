package string

import Utils.println
import kotlin.math.min

class MinOperations {
    fun minOperations(s: String): Int {
        val toCharArray = s.toCharArray()
        var times = 0
        for (ch in toCharArray.withIndex()) {
            if (ch.index > 0 && toCharArray[ch.index - 1] == ch.value) {
                toCharArray[ch.index] = ch.value.toInt().xor(1).toChar()
                times++
            }
        }
        return min(times, s.length - times)
    }
}

fun main() {
    MinOperations().minOperations("10010100").println()
}