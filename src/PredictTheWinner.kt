import kotlin.math.max

class PredictTheWinner {
    fun PredictTheWinner(nums: IntArray): Boolean {
        var dp = Array(nums.size) { IntArray(nums.size) }
        for (index in 0 until dp.size) {
            dp[index][index] = nums[index]
        }

        for (i in dp.size - 2 downTo 0) {
            for (j in i + 1 until dp.size) {
                val pickI = nums[i] - dp[i + 1][j]
                val pickJ = nums[j] - dp[i][j - 1]
                dp[i][j] = max(pickI, pickJ)
            }
        }
        return dp[0][nums.size - 1] >= 0
    }
}

fun main() {
    PredictTheWinner().PredictTheWinner(intArrayOf(1, 2, 3, 4, 5))
}