class Fib {
    fun fib(n: Int): Int {
        if (n < 2) {
            return n
        }
        var dp = IntArray(n + 1)
        dp[0] = 0
        dp[1] = 1
        for (i in 2..n) {
            dp[i] = (dp[i - 1]%1000000007 + dp[i - 2]%1000000007)%1000000007
        }
        return dp[n]
    }
}

fun main() {
    println(Fib().fib(6))
}