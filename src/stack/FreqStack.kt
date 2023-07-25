package stack

import Utils.println

class FreqStack {
    val map = HashMap<Int, Int>()
    val arr = ArrayList<Int>()
    fun push(`val`: Int) {
        arr.add(`val`)
        map[`val`] = map.getOrDefault(`val`, 0) + 1
    }

    fun pop(): Int {
        val obtainMaxKey = obtainMaxKey()
        for (i in arr.size - 1 downTo 0) {
            val `val` = arr[i]
            if (`val` in obtainMaxKey) {
                map[`val`] = map.getOrDefault(`val`, 1) - 1
                arr.removeAt(i)
                return `val`
            }
        }
        return -1
    }

    fun obtainMaxKey(): List<Int> {
        val res = ArrayList<Int>()
        var max = 0
        for (index in map) {
            if (index.value > max) {
                res.clear()
                res.add(index.key)
                max = index.value
            } else if (index.value == max) {
                res.add(index.key)
            }
        }
        return res
    }
}

fun main() {
    val stack = FreqStack()
    stack.push(5)
    stack.push(7)
    stack.push(5)
    stack.push(7)
    stack.push(4)
    stack.push(5)
    stack.pop().println()
    stack.pop().println()
    stack.pop().println()
    stack.pop().println()
}