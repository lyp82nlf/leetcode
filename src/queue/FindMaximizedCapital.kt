package queue

import Utils.println
import java.util.*
//502. IPO
class FindMaximizedCapital {
    fun findMaximizedCapital(k: Int, w: Int, profits: IntArray, capital: IntArray): Int {
        var curr = 0
        val n = capital.size
        var res = w
        val arr = Array(profits.size) {
            IntArray(2)
        }
        for (tmp in profits.withIndex()) {
            arr[tmp.index][0] = capital[tmp.index]
            arr[tmp.index][1] = tmp.value
        }
        Arrays.sort(arr) { a, b ->
            a[0] - b[0]
        }
        var pq = PriorityQueue<IntArray> { a, b ->
            b[1] - a[1]
        }
        for (i in 0 until k) {
            while (curr < n && arr[curr][0] <= res) {
                //成本足够
                pq.add(arr[curr])
                curr++
            }
            if (pq.isEmpty()) {
                break
            } else {
                val poll = pq.poll()
                res += poll[1]
            }
        }
        return res
    }
}

fun main() {
    FindMaximizedCapital().findMaximizedCapital(3, 0, intArrayOf(1, 2, 3), intArrayOf(0, 1, 2)).println()
}