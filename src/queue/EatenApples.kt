package queue

import Utils.println
import java.util.*

class EatenApples {
    fun eatenApples(apples: IntArray, days: IntArray): Int {
        //apples = [1,2,3,5,2], days = [3,2,1,4,2]
        val priorityQueue = PriorityQueue<IntArray> { p0, p1 ->
            p0[0] - p1[0]
        }
        var res = 0
        var outI = 0
        for (i in apples.indices) {
            priorityQueue.offer(intArrayOf(days[i] + i, apples[i]))
            while (priorityQueue.isNotEmpty()) {
                val apple = priorityQueue.poll()
                if (apple[0] > i && apple[1] > 0) {
                    res++
                    priorityQueue.offer(intArrayOf(apple[0], apple[1] - 1))
                    break
                }
            }
            outI++
        }
        while (priorityQueue.isNotEmpty()) {
            val apple = priorityQueue.poll()
            if (apple[0] > outI && apple[1] > 0) {
                res++
                outI++
                priorityQueue.offer(intArrayOf(apple[0], apple[1] - 1))
            }
        }
        return res
    }
}

fun main() {
    EatenApples().eatenApples(intArrayOf(3,0,0,0,0,2), intArrayOf(3,0,0,0,0,2)).println()
}