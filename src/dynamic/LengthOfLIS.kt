package dynamic

import java.util.*
import kotlin.math.max

class LengthOfLIS {
    //300. 最长递增子序列
    fun lengthOfLIS(nums: IntArray): Int {
        if (nums.isEmpty()){
            return 0
        }
        val dp = IntArray(nums.size)
        var max = 1
        Arrays.fill(dp,1)
        for (i in 1 until nums.size) {
            for (j in 0 until i){
                if (nums[i]>nums[j]){
                    dp[i] = max(dp[i],dp[j]+1)
                }
                max = max(max,dp[i])
            }
        }
        return max
    }
}