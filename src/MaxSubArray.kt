import kotlin.math.max

class MaxSubArray {
    fun maxSubArray(nums: IntArray): Int {
        var ans: Int = nums[0]
        var sum: Int = 0
        for (num in nums) {
            if (sum > 0) {
                sum += num
            } else {
                sum = num
            }
            ans = max(ans, sum)
        }
        return ans
    }
}

fun main() {
    println(MaxSubArray().maxSubArray(intArrayOf(-2, 1, -3, 4, -1, 2, 1, -5, 4)))
}