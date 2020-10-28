import kotlin.math.max
import kotlin.math.min

class MaxProduct {

    /*
    *
    * 给你一个整数数组 nums ，请你找出数组中乘积最大的连续子数组（该子数组中至少包含一个数字），并返回该子数组所对应的乘积。
    * 示例 1:
    * 输入: [2,3,-2,4]
    * 输出: 6
    * 解释: 子数组 [2,3] 有最大乘积 6。
    * */

    fun maxProduct(nums: IntArray): Int {
        var imax: Int = 1
        var imin: Int = 1
        var result: Int = Int.MIN_VALUE
        for (i in nums) {
            if (i < 0) {
                imax = imax?.xor(imin)
                imin = imax?.xor(imin)
                imax = imax?.xor(imin)
            }
            imax = max(i, i * imax)
            imin = min(i, i * imin)
            result = max(result, imax)
        }
        return result
    }
}

fun main() {
    println(MaxProduct().maxProduct(intArrayOf(2, 3, -2, 4)))
}