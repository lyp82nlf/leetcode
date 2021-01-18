package stack

import java.util.*

class DailyTemperatures {
    fun dailyTemperatures(T: IntArray): IntArray {
        val res = T.clone()
        Arrays.fill(res, 0)
        val stack = Stack<Temperature>()
        for (tIndex in T.withIndex()) {
            while (stack.isNotEmpty() && stack.peek().tmperature < tIndex.value) {
                //出栈
                val temperature = stack.pop()
                res[temperature.today] = tIndex.index - temperature.today
            }
            stack.push(Temperature(tIndex.index, tIndex.value))
        }
        return res
    }

    data class Temperature(val today: Int, val tmperature: Int)
}

fun main() {
    DailyTemperatures().dailyTemperatures(intArrayOf(73, 74, 75, 71, 69, 72, 76, 73))
}