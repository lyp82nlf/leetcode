package array

import print

class SearchRange {
    fun searchRange(nums: IntArray, target: Int): IntArray {
        val index = binarySearch(nums, target)
        if (index == -1) {
            return intArrayOf(-1, -1)
        }
        val tmpVal = nums[index]
        var left = index
        var right = index
        while (left >= 0 && nums[left] == tmpVal) {
            left--
        }
        while (right < nums.size && nums[right] == tmpVal) {
            right++
        }
        return intArrayOf(left + 1, right - 1)
    }

    fun binarySearch(nums: IntArray, target: Int): Int {
        var left = 0;
        var right = nums.size - 1;
        var mid = left + ((right - left) / 2)
        while (left <= right) {
            if (nums[mid] > target) {
                right = mid - 1
            } else if (nums[mid] < target) {
                left = mid + 1
            } else {
                return mid
            }
            mid = left + ((right - left) / 2)
        }
        return -1
    }
}

fun main() {
    SearchRange().searchRange(intArrayOf(1), 1).print()
}