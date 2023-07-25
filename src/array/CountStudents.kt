package array

import Utils.println
import java.util.*


class CountStudents {
    fun countStudents(students: IntArray, sandwiches: IntArray): Int {
        var s1 = Arrays.stream(students).sum()
        var s0 = students.size - s1
        for (sandwich in sandwiches) {
            if (sandwich == 0 && s0 > 0) {
                s0--
            } else if (sandwich == 1 && s1 > 0) {
                s1--
            } else {
                break
            }
        }
        return s1 + s0
    }
}

fun main() {
    CountStudents().countStudents(intArrayOf(1, 1, 0, 0), intArrayOf(0, 1, 0, 1)).println()
}