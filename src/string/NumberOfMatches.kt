package string

class NumberOfMatches {
    fun numberOfMatches(n: Int): Int {
        var n = n
        var sum = 0
        while (n > 1) {
            sum += n / 2
            n = (n + 1) / 2
        }
        return sum
    }
}

fun main() {
    print(NumberOfMatches().numberOfMatches(14))
}