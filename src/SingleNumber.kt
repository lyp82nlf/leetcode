class SingleNumber {
    fun singleNumber(nums: IntArray): Int {
        var num = nums[0]
        if (nums.size == 1) return num
        for (i in nums.slice(1..nums.size - 1)) {
            num = num.xor(i)
        }
        return num
    }
}

fun main() {
    println(SingleNumber().singleNumber(intArrayOf(1, 2, 3, 4, 5, 5, 4, 3, 2, 1, 10)))
}