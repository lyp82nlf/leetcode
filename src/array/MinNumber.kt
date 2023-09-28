package array

import java.util.*

class MinNumber {
    fun minNumber(nums1: IntArray, nums2: IntArray): Int {
        Arrays.sort(nums1)
        val toSet = nums2.toSet()
        for (num in nums1){
            if (toSet.contains(num)){
                return num
            }
        }
        val min1 = nums1.min()!!
        val min2 = nums2.min()!!
        return if (min1 < min2) min1 * 10 + min2 else min2 * 10 + min1
    }
}