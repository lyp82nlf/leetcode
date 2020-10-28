import kotlin.math.max

class LongestConsecutive {
    fun longestConsecutive(nums: IntArray): Int {
        var longestLen = 0
        for (num in nums) {
            if (!nums.contains(num - 1)) {
                var currentLen = 1
                var currentNum = num
                while (nums.contains(currentNum + 1)) {
                    currentNum++
                    currentLen++
                }
                longestLen = max(currentLen, longestLen)
            }
        }
        return longestLen
    }
}

fun main() {
    println(LongestConsecutive().longestConsecutive(intArrayOf(100, 200, 3, 4, 2, 1, 4, 4, 4, 4, 4)))
}