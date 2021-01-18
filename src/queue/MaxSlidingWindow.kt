package queue

import print
import java.util.*
import kotlin.math.max

class MaxSlidingWindow {
    fun maxSlidingWindow(nums: IntArray, k: Int): IntArray {
        val queue = MyQueue(k)
        val res = IntArray(nums.size - k + 1)
        for (index in nums.indices) {
            if (index < k) {
                queue.offer(Bean(index, nums[index]))
                continue
            }
            res[index - k] = queue.getMax()
            queue.offer(Bean(index, nums[index]))
        }
        res[nums.size - k] = queue.getMax()
        return res
    }

    class MyQueue(val size: Int) {
        private val myQueue = LinkedList<Bean>()
        fun offer(bean: Bean) {
            if (myQueue.size == size) {
                myQueue.pollFirst()
            }
            if (myQueue.isNotEmpty() && (bean.index - myQueue.first.index) == size) {
                myQueue.pollFirst()
            }
            while (myQueue.isNotEmpty() && myQueue.last.num < bean.num) {
                myQueue.pollLast()
            }
            myQueue.offerLast(bean)
        }

        fun getMax(): Int {
            return myQueue.peekFirst().num
        }
    }

    data class Bean(val index: Int, val num: Int)
}

fun main() {
    MaxSlidingWindow().maxSlidingWindow(intArrayOf(1, 3, 1, 2, 0, 5), 3).print()
}
