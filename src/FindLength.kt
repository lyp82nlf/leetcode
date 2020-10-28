import kotlin.math.max

class FindLength {
    /*
    * 给两个整数数组 A 和 B ，返回两个数组中公共的、长度最长的子数组的长度。
      示例：
      输入：
      A: [1,2,3,2,1]
      B: [3,2,1,4,7]
      输出：3
      解释：
      长度最长的公共子数组是 [3, 2, 1] 。
    * */
    /*
    * 动态规划 另一种思路是滑动窗口 也比较简单
    * dp方程
    * 如果当前i和j对应的数相等 则结果等于前一个结果+1 否则为0
    * */
    fun findLength(A: IntArray, B: IntArray): Int {
        var dp = Array(A.size) { IntArray(B.size) }
        var maxAns = 0
        for (a in A.withIndex()) {
            for (b in B.withIndex()) {
                if (a.value == b.value) {
                    //结尾一样 则前一个+1
                    if (a.index > 0 && b.index > 0) {
                        dp[a.index][b.index] = dp[a.index - 1][b.index - 1] + 1
                    } else {
                        dp[a.index][b.index] = 1
                    }
                    maxAns = max(maxAns, dp[a.index][b.index]);
                } else {
                    dp[a.index][b.index] = 0
                }
            }
        }
        return maxAns
    }
}

fun main() {
    println(FindLength().findLength(intArrayOf(1,2,3,2,1), intArrayOf(3,2,1,4,7)))
}