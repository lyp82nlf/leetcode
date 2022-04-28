package array

import Utils.println

class Construct2DArray {
    fun construct2DArray(original: IntArray, m: Int, n: Int): Array<IntArray> {
        if (original.size != m * n) {
            return emptyArray()
        }
        val res = Array(m) { IntArray(n) }
        for (num in original.withIndex()) {
            res[num.index / n][num.index % n] = num.value
        }
        return res
    }
}

fun main() {
    println(Construct2DArray().construct2DArray(intArrayOf(1, 2, 3), 1, 3))
}