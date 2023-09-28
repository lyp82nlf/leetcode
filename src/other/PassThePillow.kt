package other

import Utils.println

// 2582. 递枕头
class PassThePillow {
    fun passThePillow(n: Int, time: Int): Int {
        val dir = time / (n-1)
        val step = time % (n-1)
        return if (dir % 2 == 0) {
            //正向
            step + 1
        } else {
            //反向
            n - step
        }
    }
}

fun main() {
    PassThePillow().passThePillow(3, 2).println()
}