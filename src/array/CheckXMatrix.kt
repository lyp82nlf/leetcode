package array

import Utils.println

class CheckXMatrix {
    fun checkXMatrix(grid: Array<IntArray>): Boolean {
        for (row in grid.withIndex()) {
            for (col in row.value.withIndex()) {
                if (row.index == col.index || row.index + col.index == grid.size - 1) {
                    if (col.value == 0) {
                        return false
                    }
                } else {
                    if (col.value != 0) {
                        return false

                    }
                }
            }
        }
        return true
    }
}

fun main() {
    CheckXMatrix().checkXMatrix(
        arrayOf(
            intArrayOf(2, 0, 0, 1),
            intArrayOf(0, 3, 1, 0),
            intArrayOf(0, 5, 2, 0),
            intArrayOf(4, 0, 0, 2)
        )
    ).println()
}