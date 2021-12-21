package array

import Utils.println
import kotlin.math.min

class MaxCount {
    fun maxCount(m: Int, n: Int, ops: Array<IntArray>): Int {
        var l = m
        var r = n
        for (op in ops) {
            l = min(l, op[0])
            r = min(r, op[1])
        }
        return l * r
    }
}

fun main() {
    MaxCount().maxCount(3, 3, arrayOf(intArrayOf(2, 2), intArrayOf(3, 3))).println()
}