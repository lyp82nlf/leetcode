package array

import Utils.println

class MinimumAbsDifference {
    //4,3,2,1
    fun minimumAbsDifference(arr: IntArray): List<List<Int>> {
        arr.sort()
        val res = ArrayList<List<Int>>()
        var index = 0
        var minDiff = Int.MAX_VALUE
        while (index < arr.size - 1) {
            val diff = Math.abs(arr[index] - arr[index + 1])
            if (minDiff > diff) {
                res.clear()
                res.add(listOf(arr[index], arr[index + 1]))
                minDiff = diff
            } else if (minDiff == diff) {
                res.add(listOf(arr[index], arr[index + 1]))
            }
            index++
        }
        return res
    }
}

fun main() {
    MinimumAbsDifference().minimumAbsDifference(intArrayOf(3,8,-10,23,19,-4,-14,27)).println()
}