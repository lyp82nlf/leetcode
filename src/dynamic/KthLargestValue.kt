package dynamic

import java.util.*

/**
 * 1738. 找出第 K 大的异或坐标值
 */
class KthLargestValue {
    fun kthLargestValue(matrix: Array<IntArray>, k: Int): Int {
        val dp = Array(matrix.size) { IntArray(matrix[0].size, { 0 }) }
        val res = IntArray(matrix.size * matrix[0].size)
        for (row in matrix.indices) {
            for (col in 0 until matrix[0].size) {
                var leftTop = 0
                var left = 0
                var top = 0
                if (col - 1 >= 0) {
                    left = dp[row][col - 1]
                }
                if (row - 1 >= 0) {
                    top = dp[row - 1][col]
                }
                if (col - 1 >= 0 && row - 1 >= 0) {
                    leftTop = dp[row - 1][col - 1]
                }
                dp[row][col] = matrix[row][col].xor(left.xor(top).xor(leftTop))
                res[row * matrix[0].size + col] = dp[row][col]
            }
        }
        Arrays.sort(res)
        return res[res.size - k]
    }
}

fun main() {
    print(
        KthLargestValue().kthLargestValue(
            arrayOf(
                intArrayOf(3, 10, 9, 5, 5, 7),
                intArrayOf(0, 1, 7, 3, 8, 1),
                intArrayOf(9, 3, 0, 6, 1, 6),
                intArrayOf(10, 2, 9, 10, 10, 7)
            ), 19
        )
    )
}