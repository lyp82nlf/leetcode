package array

import Utils.println
import java.util.*

// 905. 按奇偶排序数组
class SortArrayByParity {
    fun sortArrayByParity(nums: IntArray): IntArray {
        var l = 0
        var r = nums.size-1
        while (l<r){
            while (l<r && nums[l] %2 == 0){
                l++
            }
            while (l<r && nums[r]%2 != 0){
                r--
            }
            val tmp = nums[l]
            nums[l] = nums[r]
            nums[r] = tmp
        }
        return nums
    }
}

fun main() {
    SortArrayByParity().sortArrayByParity(intArrayOf(3,1,2,4)).println()
}