package array

import java.util.*
import kotlin.Comparator


class Merge {
    fun merge(intervals: Array<IntArray>): Array<IntArray> {
        Arrays.sort(intervals) { o1: IntArray, o2: IntArray ->
            o1[0] - o2[0]
        }
        val ans = Stack<IntArray>()
        for (interval in intervals) {
            if (ans.isEmpty()) {
                ans.add(interval)

                continue
            }
            if (ans.peek()[1] < interval[0]) {
                //无区间相关
                ans.push(interval)
            } else {
                val pop = ans.pop()
                ans.push(intArrayOf(Math.min(pop[0], interval[0]), Math.max(pop[1], interval[1])))
            }
        }
        return ans.toTypedArray()
    }
}