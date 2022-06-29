package queue

import Utils.println
import java.util.concurrent.LinkedBlockingQueue

class RecentCounter {
    private val queue = LinkedBlockingQueue<Int>()
    fun ping(t: Int): Int {
        queue.offer(t)
        while (queue.peek() < t - 3000) {
            queue.poll()
        }
        return queue.size
    }
}

fun main() {
    val recentCounter = RecentCounter()
    recentCounter.ping(1).println()
    recentCounter.ping(100).println()
    recentCounter.ping(3001).println()
    recentCounter.ping(3002).println()
}