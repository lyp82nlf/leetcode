package string

import Utils.println
import kotlin.math.max

/**
 * 868. 二进制间距
 */

class BinaryGap {
    // 10001
    fun binaryGap(n: Int): Int {
        var res = 0
        var last = -1
        var n = n
        var current = 0
        while (n > 0) {
            current++
            if (n % 2 == 1) {
                if (last != -1) {
                    res = max(res, current - last)
                }
                last = current
            }
            n /= 2
        }
        return res
    }
}

fun main() {
    BinaryGap().binaryGap(5).println()
}