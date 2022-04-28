package string

import Utils.println
import java.lang.StringBuilder
import kotlin.math.absoluteValue

class ConvertToBase7 {
    fun convertToBase7(num: Int): String {
        if (num > -7 && num < 7) {
            return num.toString()
        }
        val res = StringBuilder()
        val symbol = if (num < 0) "-" else ""
        var num = num.absoluteValue
        while (num >= 7) {
            res.append(num % 7)
            num /= 7
        }
        res.append(num)
        res.reverse()
        res.insert(0, symbol)
        return res.toString()
    }
}

fun main() {
    ConvertToBase7().convertToBase7(-100).println()
}