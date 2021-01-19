package sort

import kotlin.math.max

class MaximumProduct {
    fun maximumProduct(nums: IntArray): Int {
        nums.sortDescending()
        return max(nums[0] * nums[1] * nums[2], nums[0] * nums[nums.size - 1] * nums[nums.size - 2])
    }
}