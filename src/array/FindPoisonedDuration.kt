package array

import Utils.println

class FindPoisonedDuration {
    fun findPoisonedDuration(timeSeries: IntArray, duration: Int): Int {
        var sum = 0
        for (cur in timeSeries.withIndex()) {
            if (cur.index == timeSeries.size - 1) {
                return sum + duration
            }
            val diff = timeSeries[cur.index + 1] - cur.value
            sum += if (diff <= duration) diff else duration
        }
        return sum
    }
}

fun main() {
    FindPoisonedDuration().findPoisonedDuration(intArrayOf(1,2),2).println()
}