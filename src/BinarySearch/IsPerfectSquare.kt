package BinarySearch

import Utils.println

class IsPerfectSquare {
    fun isPerfectSquare(num: Int): Boolean {
        if (num == 1){
            return true
        }
        var left = 0
        var right = num
        while (left <= right) {
            val middle = left + (right - left) / 2
            val diff = num.toFloat() / middle
            when {
                diff == middle.toFloat() -> return true
                diff > middle -> left = middle + 1
                else -> right = middle - 1
            }
        }
        return false
    }
}

fun main() {
    IsPerfectSquare().isPerfectSquare(5).println()
}