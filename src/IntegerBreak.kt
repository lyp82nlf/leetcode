class IntegerBreak {
    fun integerBreak(n: Int): Int {
        if (n == 2) {
            return 1
        }
        if (n == 3) {
            return 2
        }
        var tmpArgs = n
        var ans = 1
        while (tmpArgs > 4) {
            ans *= 3
            tmpArgs -= 3
        }
        if (tmpArgs == 4) {
            ans *= 4
        } else {
            ans *= tmpArgs
        }

        return ans
    }
}

fun main() {
    println(IntegerBreak().integerBreak(10))
}