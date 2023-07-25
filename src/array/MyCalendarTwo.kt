package array

import Utils.println

class MyCalendarTwo {
    val books = mutableListOf<IntArray>()
    fun book(start: Int, end: Int): Boolean {
        var bookedTimes = 0
        looper@ for (book in books) {
            if (end > book[0] && start < book[1]) {
                if (bookedTimes == 1) {
                    return false
                }
                bookedTimes++
                continue@looper
            }
        }
        books.add(intArrayOf(start, end))
        return true
    }
}

fun main() {
    val myCalendarTwo = MyCalendarTwo()
    myCalendarTwo.book(10, 20).println()
    myCalendarTwo.book(50, 60).println()
    myCalendarTwo.book(10, 40).println()
    myCalendarTwo.book(5, 15).println()
    myCalendarTwo.book(5, 10).println()
    myCalendarTwo.book(25, 55).println()
}