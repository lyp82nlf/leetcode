package array

import Utils.println
import java.lang.StringBuilder

class DecodeMessage {
    fun decodeMessage(key: String, message: String): String {
        val secret = CharArray(26)
        var start = 97
        for (ch in key) {
            if (ch == ' ') {
                continue
            }
            if (secret[ch.toInt() - 97] == '\u0000') {
                secret[ch.toInt() - 97] = start.toChar()
                start++
            }
        }
        val res = StringBuilder()
        for (ch in message) {
            if (ch == ' ') {
                res.append(' ')
            } else {
                res.append(secret[ch.toInt() - 97])
            }
        }
        return res.toString()
    }
}

fun main() {
    DecodeMessage().decodeMessage("the quick brown fox jumps over the lazy dog", "vkbs bs t suepuv").println()
}