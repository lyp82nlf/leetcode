package recursion

class NumDecodings {
    fun numDecodings(s: String): Int {
        if (s.isEmpty()) {
            return 0
        }
        val dp = IntArray(s.length + 1)
        dp[0] = 1
        dp[1] = if (s[0] == '0') 0 else 1
        for (i in 1 until s.length) {
            if (s[i - 1] == '1' || s[i - 1] == '2' && s[i] < '7') {
                if (s[i] == '0') {
                    //10,20
                    dp[i + 1] = dp[i - 1]
                } else {
                    dp[i + 1] = dp[i] + dp[i - 1]
                }
            } else {
                if (s[i] == '0') {
                    return 0
                }
                dp[i + 1] = dp[i]
            }
        }
        return dp[s.length]
    }
}