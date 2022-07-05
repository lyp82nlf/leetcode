import Utils.println

//729. 我的日程安排表 I
class MyCalendar {
    private val booked = mutableListOf<IntArray>()
    fun book(start: Int, end: Int): Boolean {
        for (index in booked) {
            if (index[0]<end && start<index[1]){
                return false
            }
        }
        booked.add(intArrayOf(start,end))
        return true
    }
}

fun main() {
    val calendar = MyCalendar()
    calendar.book(10,20).println()
    calendar.book(15,25).println()
    calendar.book(20,30).println()
}