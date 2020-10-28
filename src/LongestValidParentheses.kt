import kotlin.math.max

class LongestValidParentheses {
    /*
    * 给定一个只包含 '(' 和 ')' 的字符串，找出最长的包含有效括号的子串的长度。
    * 示例 1:
    * 输入: "(()"
    * 输出: 2
    * 解释: 最长有效括号子串为 "()"
    * 示例 2:
    * 输入: ")()())"
    * 输出: 4
    * 解释: 最长有效括号子串为 "()()"
    * */
    /*
    * 思路:动态规划  栈
    * 动态规划 Dp[]数组 dp[i]表示以i当前符号结尾的最长子串长度
    * */
    fun longestValidParentheses(s: String): Int {
        var maxAns = 0
        var dp = Array(s.length) { 0 }
        for (index in 0 until s.length) {
            if (s[index] == ')' && index > 1) {
                if (s[index - 1] == '(') {
                    dp[index] = (if (index >= 2) dp[index - 2] else 0) + 2
                } else if (index - dp[index - 1] > 0 && s[index - dp[index - 1] - 1] == '(') {
                    dp[index] = dp[index - 1] + (if (index - dp[index - 1] >= 2) dp[index - dp[index - 1] - 2] else 0) + 2
                }
            }
            maxAns = max(maxAns, dp[index])
        }
        return maxAns
    }
}

