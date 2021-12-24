package string

import Utils.println
import kotlin.math.pow
import kotlin.random.Random

/*
1044. 最长重复子串
采用二分+哈希来解决
hash冲突采用双进制来解决
 */
class LongestDupSubstring {
    fun longestDupSubstring(s: String): String {
        //双进制
        val a1 = Random.nextInt(75) + 26
        val a2 = Random.nextInt(75) + 26
        //取模
        val mod1 = Random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007
        val mod2 = Random.nextInt(Integer.MAX_VALUE - 1000000007 + 1) + 1000000007
        val arr = IntArray(s.length)
        for (ch in s.withIndex()) {
            arr[ch.index] = s[ch.index] - 'a'
        }
        var l = 1
        var r = s.length - 1
        var res = ""
        while (l <= r) {
            val mid = l + (r - l) / 2
            val i = check(arr, mid, a1, mod1, a2, mod2)
            if (i == -1) {
                r = mid - 1
            } else {
                l = mid + 1
                res = s.substring(i, i + mid)
            }
        }
        return res
    }

    fun check(arr: IntArray, m: Int, a1: Int, a2: Int, mod1: Int, mod2: Int): Int {
        val n = arr.size
        val aL1 = pow(a1, m, mod1)
        val aL2 = pow(a2, m, mod2)
        var h1: Long = 0
        var h2: Long = 0
        for (i in 0 until m) {
            h1 = (h1 * a1 % mod1 + arr[i]) % mod1
            h2 = (h2 * a2 % mod2 + arr[i]) % mod2
            if (h1 < 0) {
                h1 += mod1
            }
            if (h2 < 0) {
                h2 += mod2
            }
        }
        // 存储一个编码组合是否出现过
        val seen = HashSet<Long>()
        seen.add(h1 * mod2 + h2)
        for (start in 1..(n - m)) {
            h1 = (h1 * a1 % mod1 - arr[start - 1] * aL1 % mod1 + arr[start + m - 1]) % mod1
            h2 = (h2 * a2 % mod2 - arr[start - 1] * aL2 % mod2 + arr[start + m - 1]) % mod2
            if (h1 < 0) {
                h1 += mod1
            }
            if (h2 < 0) {
                h2 += mod2
            }

            val num = h1 * mod2 + h2
            // 如果重复，则返回重复串的起点
            if (!seen.add(num)) {
                return start
            }
        }
        // 没有重复，则返回-1
        return -1
    }

    fun pow(a: Int, m: Int, mod: Int): Long {
        var ans: Long = 1
        var contribute: Long = a.toLong()
        var m = m
        while (m > 0) {
            if (m % 2 == 1) {
                ans = ans * contribute % mod
                if (ans < 0) {
                    ans += mod
                }
            }
            contribute = contribute * contribute % mod
            if (contribute < 0) {
                contribute += mod
            }
            m /= 2
        }
        return ans
    }
}

fun main() {
    LongestDupSubstring().longestDupSubstring(
        "banana"
    ).println()
}