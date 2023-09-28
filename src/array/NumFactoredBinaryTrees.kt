package array

import Utils.print
import java.util.*


/**
 * 823. 带因子的二叉树
 * 1 2 3 4 6 10
 */
class NumFactoredBinaryTrees {
    fun numFactoredBinaryTrees(arr: IntArray): Int {
        val mod = 1e9.toInt() + 7
        Arrays.sort(arr)
        val n = arr.size
        val f = LongArray(n)
        Arrays.fill(f, 1)
        val idx: MutableMap<Int, Int?> = HashMap(n)
        for (i in 0 until n) {
            idx[arr[i]] = i
        }
        for (i in 0 until n) {
            val a = arr[i]
            for (j in 0 until i) {
                val b = arr[j]
                if (a % b == 0) {
                    val c = a / b
                    if (idx.containsKey(c)) {
                        val k = idx[c]!!
                        f[i] = (f[i] + f[j] * f[k]) % mod
                    }
                }
            }
        }
        var ans: Long = 0
        for (v in f) {
            ans = (ans + v) % mod
        }
        return ans.toInt()
    }
}

fun main() {
    NumFactoredBinaryTrees().numFactoredBinaryTrees(intArrayOf(36,3,6,2)).print()
}