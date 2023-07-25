package array

import Utils.println

class Shuffle {
    fun shuffle(nums: IntArray, n: Int): IntArray {
        val res = IntArray(nums.size)
        for (x in 0 until n){
            res[x*2] = nums[x]
            res[x*2+1] = nums[x+n]
        }
        return res
    }
}

fun main() {
    Shuffle().shuffle(intArrayOf(1,2,3,4,4,3,2,1),4).println()
}