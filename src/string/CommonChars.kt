package string

import java.util.*
import kotlin.math.min

class CommonChars {
    fun commonChars(A: Array<String>): List<String> {
        val minArr = arrayOfNulls<Int>(26)
        Arrays.fill(minArr, 0)
        if (A.isEmpty()) {
            return emptyList()
        }
        for (char in A[0]) {
            minArr[char - 'a'] = minArr[char - 'a']!! + 1
        }
        for (str in A) {
            val tmp = arrayOfNulls<Int>(26)
            Arrays.fill(tmp, 0)
            for (ch in str) {
                tmp[ch - 'a'] = tmp[ch - 'a']!! + 1
            }
            for (index in 0 until minArr.size) {
                minArr[index] = min(minArr[index]!!, tmp[index]!!)
            }
        }
        var res = mutableListOf<String>()
        for (index in 0 until minArr.size) {
            res.addTimes(minArr[index]!!, ('a' + index).toString())
        }
        return res
    }

    fun <T> MutableList<T>.addTimes(times: Int, content: T) {
        for (i in 0 until times) {
            add(content)
        }
    }
}

fun main() {
    CommonChars().commonChars(arrayOf("bella", "label", "roller"))
}