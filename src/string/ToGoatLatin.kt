package string

import Utils.println
import Utils.times
import java.lang.StringBuilder

//824. 山羊拉丁文
class ToGoatLatin {

    fun toGoatLatin(sentence: String): String {
        val arr = sentence.split(" ")
        var index = 1
        val res = StringBuilder()
        for (str in arr) {
            if (str[0].toLowerCase() in charArrayOf('a', 'e', 'i', 'o', 'u')) {
                res.append(str)
            } else {
                res.append(str.substring(1))
                res.append(str[0])
            }
            res.append("ma")
            res.append("a" * index)
            res.append(" ")
            index++
        }
        return res.toString().trimEnd()
    }
}

fun main() {
    ToGoatLatin().toGoatLatin("I speak Goat Latin").println()
}