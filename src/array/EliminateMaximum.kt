package array

import java.util.*

class EliminateMaximum {
    fun eliminateMaximum(dist: IntArray, speed: IntArray): Int {
        val rounds = IntArray(dist.size)
        for ((index, monster) in dist.withIndex()) {
            rounds[index] = Math.ceil(monster / speed[index].toDouble()).toInt()
        }
        Arrays.sort(rounds)
        var times = 0
        var ans = 0
        // 1 2 2 3
        for ((index, round) in rounds.withIndex()) {
            if (round <= times) {
                ans = index
                break
            } else {
                times++
            }
        }
        return if (ans == 0) dist.size else ans
    }
}

fun main() {
    EliminateMaximum().eliminateMaximum(intArrayOf(1,1,2,3), intArrayOf(1,1,1,1))
}