package other

import Utils.println
import kotlin.math.roundToInt
import kotlin.math.sqrt

class CheckPerfectNumber {
    fun checkPerfectNumber(num: Int): Boolean {
        if (num == 1) {
            return false
        }
        var sum = 1
        val end = sqrt(num.toDouble()).roundToInt()
        for (i in 2..end) {
            if (num % i == 0) {
                sum += i
                sum += (num / i)
            }
        }
        return sum == num
    }
}

fun main() {
    CheckPerfectNumber().checkPerfectNumber(7).println()
}