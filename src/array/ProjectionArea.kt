package array

import Utils.println
import kotlin.math.max

/**
 * 883. 三维形体投影面积
 * 1,2
 * 3,4
 */
class ProjectionArea {
    fun projectionArea(grid: Array<IntArray>): Int {
        if (grid.isEmpty()) {
            return 0
        }
        var zDirectionSum = 0
        var xDirectionSum = 0
        val yDirectionSum = IntArray(grid.size)
        for (row in grid.withIndex()) {
            xDirectionSum += row.value.max()!!
            for (col in row.value.withIndex()) {
                if (col.value != 0) {
                    zDirectionSum++
                }
                yDirectionSum[col.index] = max(yDirectionSum[col.index], col.value)
            }
        }
        return zDirectionSum + xDirectionSum + yDirectionSum.sum()
    }
}

fun main() {
    ProjectionArea().projectionArea(arrayOf(intArrayOf(1,0), intArrayOf(0,2))).println()
}