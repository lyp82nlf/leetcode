package recursion

import kotlin.math.max

/**
 * 1035. 不相交的线
 * 思维不能定式  确实是最长公共子序列问题
 */
class MaxUncrossedLines {
    fun maxUncrossedLines(nums1: IntArray, nums2: IntArray): Int {
        val dp = Array(nums1.size + 1) {
            IntArray(nums2.size + 1)
        }
        for (row in 1..nums1.size) {
            for (col in 1..nums2.size) {
                if (nums1[row - 1] == nums2[col - 1]) {
                    dp[row][col] = dp[row - 1][col - 1] + 1
                } else {
                    dp[row][col] =
                        max(
                            dp[row - 1][col],
                            dp[row][col - 1]
                        )
                }
            }
        }
        return dp[nums1.size][nums2.size]
    }
}

fun main() {
    print(MaxUncrossedLines().maxUncrossedLines(intArrayOf(1, 3, 7, 1, 7, 5), intArrayOf(1, 9, 2, 5, 1)))
}