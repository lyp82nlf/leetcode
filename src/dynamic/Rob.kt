package dynamic

import kotlin.math.max

class Rob {
    //198. 打家劫舍
    fun rob(nums: IntArray): Int {
        if (nums.isEmpty()){
            return 0
        }
        if (nums.size == 1) {
            return nums[0]
        }
        val dp = IntArray(nums.size + 1)
        dp[0] = 0
        dp[1] = nums[0]
        for (i in 2..nums.size){
            dp[i] = max(nums[i-1]+dp[i-2],dp[i-1])
        }
        return dp[nums.size]
    }
}

fun main() {
    println(Rob().rob(intArrayOf(2, 7, 9, 3, 1)))
}