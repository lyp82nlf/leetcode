package array

import Utils.println
import java.lang.StringBuilder

class AmbiguousCoordinates {
    fun ambiguousCoordinates(s: String): List<String> {
        val res = mutableListOf<String>()
        val number = s.substring(1, s.length-1)
        for (index in 1 until number.length) {
            val left = number.substring(0, index)
            val right = number.substring(index, number.length)
            for (l in getValidNum(left)) {
                for (r in getValidNum(right)) {
                    res.add(
                        StringBuilder().append("(")
                            .append(l)
                            .append(", ")
                            .append(r)
                            .append(")").toString()
                    )
                }
            }
        }
        return res
    }

    //(23)  2.3  23
    fun getValidNum(s: String): List<String> {
        if (s.isEmpty()) {
            return emptyList()
        }
        var left: String
        var right: String
        var index = 1
        val res = mutableListOf<String>()
        while (index <= s.length) {
            left = s.substring(0, index)
            right = s.substring(index)
            index++
            if ((left != "0" && left[0] == '0') || (right.isNotEmpty() && right.endsWith("0"))) {
                continue
            } else if (right.isEmpty()) {
                res.add(left)
            } else {
                res.add(StringBuilder().append(left).append(".").append(right).toString())
            }
        }
        return res
    }
}

fun main() {
    AmbiguousCoordinates().ambiguousCoordinates("(123)").println()
}