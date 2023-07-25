package queue

import Utils.println
import java.util.*
//2208. 将数组和减半的最少操作次数
class HalveArray {
    fun halveArray(nums: IntArray): Int {
        val queue = PriorityQueue<Double> { t, t2 -> t2.compareTo(t) }
        var half = 0.0
        for (num in nums) {
            queue.offer(num.toDouble())
            half += num
        }
        half /= 2
        var times = 0
        while (half > 0) {
            val poll = queue.poll() / 2
            half -= poll
            queue.offer(poll)
            times++
        }
        return times
    }
}

fun main() {
    HalveArray().halveArray(intArrayOf(1, 1, 1, 1)).println()
}