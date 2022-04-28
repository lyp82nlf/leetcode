package recursion

import Utils.println

class AddDigits {
    fun addDigits(num: Int): Int {
        if (num == 10){
            return 1
        }
        if (num < 10) {
            return num
        }
        var result = 0
        var num = num
        while (num > 10) {
            result += num % 10
            num /= 10
        }
        result += num
        return addDigits(result)
    }
}

fun main() {
    AddDigits().addDigits(10).println()
}