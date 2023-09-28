package array

import kotlin.math.min

class Insert {
    fun insert(intervals: Array<IntArray>, newInterval: IntArray): Array<IntArray> {
        if (intervals.isEmpty()) {
            return arrayOf(newInterval)
        }
        var mergeLeft = newInterval[0]
        var mergeRight = newInterval[1]
        val ans = mutableListOf<IntArray>()
        var placed = false
        for (interval in intervals) {
            // 不在区间内
            if (interval[1] < mergeLeft) {
                ans.add(interval)
                continue
            }
            if (interval[0] > mergeRight) {
                if (!placed) {
                    ans.add(intArrayOf(mergeLeft, mergeRight))
                    placed = true
                }
                ans.add(interval)
                continue
            }
            mergeLeft = Math.min(mergeLeft, interval[0])
            mergeRight = Math.max(mergeRight, interval[1])
        }
        if (!placed){
            ans.add(intArrayOf(mergeLeft, mergeRight))
        }
        return ans.toTypedArray()
    }
}

fun main() {
    Insert().insert(arrayOf(intArrayOf(1, 3), intArrayOf(6, 9)), intArrayOf(2, 5))
}