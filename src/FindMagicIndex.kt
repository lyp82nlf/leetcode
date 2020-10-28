class FindMagicIndex {
    fun findMagicIndex(nums: IntArray): Int {
        for (num in nums.withIndex()) {
            if (num.index == num.value) return num.index
        }
        return -1
    }
}

fun main() {
    println(FindMagicIndex().findMagicIndex(intArrayOf(1, 1, 1)))
}