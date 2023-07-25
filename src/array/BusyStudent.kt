package array

class BusyStudent {
    fun busyStudent(startTime: IntArray, endTime: IntArray, queryTime: Int): Int {
        var res = 0
        for (index in startTime.indices) {
            if (startTime[index] <= queryTime && endTime[index] >= queryTime) {
                res++
            }
        }
        return res
    }
}