package array

import Utils.println
import kotlin.math.absoluteValue

/**
 * 2596. 检查骑士巡视方案
 */
class CheckValidGrid {
    fun checkValidGrid(grid: Array<IntArray>): Boolean {
        val map = mutableMapOf<Int, IntArray>()
        for ((rowIndex, row) in grid.withIndex()) {
            for ((colIndex, col) in row.withIndex()) {
                map[col] = intArrayOf(rowIndex, colIndex)
            }
        }
        if (grid[0][0] != 0) {
            return false
        }
        for ((key, value) in map) {
            if (key == grid.size * grid.size - 1) {
                continue
            }
            if (!check(value, map.getOrDefault(key + 1, intArrayOf(0, 0)))) {
                return false
            }
        }
        return true
    }

    fun check(point1: IntArray, point2: IntArray): Boolean {
        val rowAbsolute = (point1[0] - point2[0]).absoluteValue
        val colAbsolute = (point1[1] - point2[1]).absoluteValue
        return (rowAbsolute - colAbsolute).absoluteValue == 1 && (colAbsolute == 1 || colAbsolute == 2)
    }
}

fun main() {
    CheckValidGrid().checkValidGrid(
        arrayOf(
            intArrayOf(0, 11, 16, 5, 20), intArrayOf(17, 4, 19, 10, 15), intArrayOf(12, 1, 8, 21, 6),
            intArrayOf(3, 18, 23, 14, 9), intArrayOf(24, 13, 2, 7, 22)
        )
    ).println()
}