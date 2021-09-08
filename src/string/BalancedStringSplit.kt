package string

import Utils.println

class BalancedStringSplit {
    fun balancedStringSplit(s: String): Int {
        var l = 0
        var r = 0
        var res = 0
        for (ch in s) {
            if (ch == 'L') {
                l++
            } else {
                r++
            }
            if (l == r) {
                res++
                l = 0
                r = 0
            }
        }
        return res
    }
}

fun main() {
    BalancedStringSplit().balancedStringSplit("RLRRRLLRLL").println()
}