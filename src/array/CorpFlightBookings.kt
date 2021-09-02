package array

import print

class CorpFlightBookings {
    fun corpFlightBookings(bookings: Array<IntArray>, n: Int): IntArray {
        val res = IntArray(n)
        for (book in bookings) {
            for (i in book[0]..book[1]) {
                res[i - 1] = res[i - 1] + book[2]
            }
        }
        return res
    }
}

fun main() {
    CorpFlightBookings().corpFlightBookings(
        arrayOf(intArrayOf(1, 2, 10), intArrayOf(2,2,15)),
        2
    ).print()
}