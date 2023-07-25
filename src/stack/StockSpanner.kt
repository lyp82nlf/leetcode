package stack

import Utils.println
import java.util.*

/**
 * 单调栈
 */
class StockSpanner {
    val stack = Stack<(IntArray)>()
    var index = 0
    fun next(price: Int): Int {
        index++
        while (stack.isNotEmpty() && stack.peek()[1] <= price) {
            stack.pop()
        }

        if (stack.isEmpty()) {
            stack.push((intArrayOf(index, price)))
            return index
        } else {
            val res = index - stack.peek()[0]
            stack.push((intArrayOf(index, price)))
            return res
        }
    }
}

fun main() {
    val spanner = StockSpanner()
    spanner.next(100).println()
    spanner.next(80).println()
    spanner.next(60).println()
    spanner.next(70).println()
    spanner.next(60).println()
    spanner.next(75).println()
    spanner.next(85).println()
}