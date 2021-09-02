package array

import Utils.println
import java.util.*

class MedianFinder {
    val l = PriorityQueue<Int> { a, b -> b - a }//大顶堆
    val r = PriorityQueue<Int> { p0, p1 -> p0 - p1 }//小顶堆

    fun addNum(num: Int) {
        if (l.isEmpty()) {
            l.add(num)
        } else if (l.size == r.size) {
            //当前是偶数
            if (num <= r.peek()) {
                l.add(num)
            } else {
                l.add(r.poll())
                r.add(num)
            }
        } else {
            //当前是奇数
            if (num >= l.peek()) {
                r.add(num)
            } else {
                r.add(l.poll())
                l.add(num)
            }
        }
    }

    fun findMedian(): Double {
        if (l.isEmpty()) {
            return 0.0
        }
        if (l.size == r.size) {
            //偶数
            return (l.peek() + r.peek()).toDouble() / 2
        } else {
            return l.peek().toDouble()
        }
    }
}

fun main() {
    val test = MedianFinder()
    test.addNum(1)
    test.addNum(2)
    test.findMedian().println()
    test.addNum(3)
    test.findMedian().println()
    test.addNum(4)
    test.findMedian().println()
    test.addNum(5)
    test.findMedian().println()
}