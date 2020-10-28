class NumWays {
    fun numWays(n: Int): Int {
        if (n < 2) {
            return 1
        }
        var dp = IntArray(n + 1)
        dp[0] = 1
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = (dp[i - 1] % 1000000007 + dp[i - 2] % 1000000007) % 1000000007
        }
        return dp[n]
    }
}

fun main() {
    println(NumWays().numWays(2))
    println(NumWays().numWays(7))
    println(NumWays().numWays(0))
}