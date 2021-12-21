package string

/*
1154. 一年中的第几天
 */
class DayOfYear {
    fun dayOfYear(date: String): Int {
        val splits = date.split('-')
        val year = splits[0].toInt()
        val month = splits[1].toInt()
        val day = splits[2].toInt()
        val monthDays = intArrayOf(31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31)
        if ((year % 4 == 0) and (year % 100 != 0) or (year % 400 == 0)) {
            monthDays[1]++
        }
        var sum = 0
        for (i in 0 until month - 1) {
            sum += monthDays[i]
        }
        sum += day
        return sum
    }
}

fun main() {
    print(DayOfYear().dayOfYear("2003-03-01"))
}