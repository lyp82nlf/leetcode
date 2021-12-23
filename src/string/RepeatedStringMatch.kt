package string

import Utils.println
/*
686. 重复叠加字符串匹配
 */
class RepeatedStringMatch {
    fun repeatedStringMatch(a: String, b: String): Int {
        var str = a
        var count = 1
        while (str.length <= b.length) {
            if (str.length == b.length && str == b) {
                return count
            }
            str += a
            count++
        }
        if (b in str) {
            return count
        } else {
            if (b in str + a) {
                return count + 1
            }
            return -1
        }
    }
}

fun main() {
    RepeatedStringMatch().repeatedStringMatch("abcd", "cdabcdabcda").println()
}