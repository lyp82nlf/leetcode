package array

import Utils.println
import kotlin.math.abs

class NearestValidPoint {
    fun nearestValidPoint(x: Int, y: Int, points: Array<IntArray>): Int {
        var manhadun = Int.MAX_VALUE
        var res = -1
        for (point in points.withIndex()) {
            if (point.value[0] == x || point.value[1] == y) {
                if (abs(x - point.value[0]) + abs(y - point.value[1]) < manhadun) {
                    manhadun = abs(x - point.value[0]) + abs(y - point.value[1])
                    res = point.index
                }
            }
        }
        return res
    }
}

fun main() {
    NearestValidPoint().nearestValidPoint(
        3, 4, arrayOf(
            intArrayOf(1, 2), intArrayOf(3, 1), intArrayOf(2, 4), intArrayOf(2, 3),
            intArrayOf(4, 4)
        )
    ).println()
}