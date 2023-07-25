package array

import Utils.println

class MaxProduct {
    fun maxProduct(nums: IntArray): Int {
        val a = nums.max()!!
        nums[nums.indexOf(a)] = 0
        val b = nums.max()!!
        return (a - 1) * (b - 1)
    }
}

fun main() {
    MaxProduct().maxProduct(intArrayOf(3,7)).println()
}