package array

import Utils.println
import java.util.*

class FindPeakElement {
    fun findPeakElement(nums: IntArray): Int {
        for (i in 1 until nums.size) {
            if (nums[i] < nums[i - 1]) {
                return i - 1
            }
        }
        return nums.size - 1
    }
}


fun main() {
    FindPeakElement().findPeakElement(intArrayOf(1)).println()
}