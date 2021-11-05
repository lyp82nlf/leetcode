package dynamic

import Utils.println
import kotlin.math.max

//1218. 最长定差子序列
class LongestSubsequence {
    fun longestSubsequence(arr: IntArray, difference: Int): Int {
        val dp = IntArray(arr.size)
        dp[0] = 1
        val map = HashMap<Int, Int>()
        map[arr[0]] = 0
        var max = 1
        for (index in 1 until arr.size) {
            val num = arr[index] - difference
            if (map.containsKey(num)) {
                dp[index] = dp[map[num]!!] + 1
                max = max(max, dp[index])
            } else {
                dp[index] = 1
            }
            map[arr[index]] = index
        }
        return max
    }
}

fun main() {
    LongestSubsequence().longestSubsequence(intArrayOf(1, 22, 34, 4), difference = 1).println()
}