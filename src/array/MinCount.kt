package array

class MinCount {
    fun minCount(coins: IntArray): Int {
        var ans = 0
        for (coin in coins) {
            ans += (coin + 1) / 2
        }
        return ans
    }
}