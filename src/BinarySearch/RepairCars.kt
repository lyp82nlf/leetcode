package BinarySearch

import Utils.println

/**
 * 2594. 修车的最少时间
 */
class RepairCars {
    fun repairCars(ranks: IntArray, cars: Int): Long {
        var l = 1L
        var r = 1L * ranks[0] * cars * cars
        while (l < r) {
            val m = (l + r) / 2
            if (check(ranks, cars, m)) {
                r = m
            } else {
                l = m+1
            }
        }
        return r
    }

    private fun check(ranks: IntArray, cars: Int, m: Long): Boolean {
        var sum = 0L
        for (rank in ranks) {
            sum += Math.sqrt((m / rank).toDouble()).toLong()
        }
        return sum >= cars
    }
}

fun main() {
    RepairCars().repairCars(intArrayOf(4, 2, 3, 1),10).println()
}