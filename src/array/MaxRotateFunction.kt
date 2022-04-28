package array

import Utils.println
import print
import kotlin.math.max

//396. 旋转函数

class MaxRotateFunction {
    //4326
    //6432
    //2643
    //3264
    fun maxRotateFunction(nums: IntArray): Int {
        var nums = nums
        if (nums.size <= 1) {
            return 0
        }
        var pre = 0
        val sum = nums.sum()
        for (index in nums.indices) {
            pre += index * nums[index]
        }
        var res = pre
        for (index in nums.size - 1 downTo 1) {
            pre += sum - nums.size * nums[index]
            res = max(res,pre)
        }
        return res
    }

    fun rotateNum(nums: IntArray): IntArray {
        val res = IntArray(nums.size)
        res[0] = nums.last()
        for (index in 0 until nums.size - 1) {
            res[index + 1] = nums[index]
        }
        return res
    }

}

fun main() {
    MaxRotateFunction().maxRotateFunction(intArrayOf(4, 3, 2, 6)).println()
}

