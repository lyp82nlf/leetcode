package sort

import Utils.println

/**
 * 268. 丢失的数字
 */
class MissingNumber {
    fun missingNumber(nums: IntArray): Int {
        nums.sort()
        var res = 0
        for (i in nums){
            if (i!=res){
                return res
            }else{
                res++
            }
        }
        return res
    }
}

fun main() {
    MissingNumber().missingNumber(intArrayOf(9,6,4,2,3,5,7,0,1)).println()
}