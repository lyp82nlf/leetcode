package array

import Utils.println

class WaysToBuyPensPencils {
    fun waysToBuyPensPencils(total: Int, cost1: Int, cost2: Int): Long {
        var ans = 0L
        var num1 = total / cost1
        while (num1 >= 0) {
            val remain = total - num1 * cost1
            ans += (remain / cost2 + 1)
            num1--
        }
        return ans
    }
}

fun main() {
    WaysToBuyPensPencils().waysToBuyPensPencils(5,10,5).println()
}