package dynamic

import kotlin.math.max

class LongestPalindromeSubseq {
    //516. 最长回文子序列
    fun longestPalindromeSubseq(s: String): Int {
        if (s.length == 1) {
            return 1
        }
        val dp = Array<IntArray>(s.length) { IntArray(s.length) }
        for (i in s.indices) {
            dp[i][i] = 1
        }
        var max = 0


        for (len in 2..s.length) {
            for (i in 0..s.length - len) {
                val j = i + len - 1
                if (s[i] == s[j]) {
                    //端点相等
                    dp[i][j] = if (len == 2) 2 else 2 + dp[i + 1][j - 1]
                } else {
                    dp[i][j] = max(dp[i + 1][j], dp[i][j - 1])
                }
                max = max(max, dp[i][j])
            }
        }
        return max
    }
}

fun main() {
    print(LongestPalindromeSubseq().longestPalindromeSubseq("aaabbba"))
}