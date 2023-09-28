package array

/**
 * 1654. 到家的最少跳跃次数
 * 没做出来
 */
class MinimumJumps {
    fun minimumJumps(forbidden: IntArray, a: Int, b: Int, x: Int): Int {
        val diff = a - b
        if (x % a != 0 && x % diff != 0) {
            return -1
        }
        val forbiddenSet = forbidden.toSet()
        var ans = 0
        if (x % a == 0) {
            var a = x
        }
        return 0
    }
}