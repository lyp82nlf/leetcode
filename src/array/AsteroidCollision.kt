package array

import Utils.println
import java.util.*
//735. 行星碰撞
class AsteroidCollision {
    // 10 5 -5 10
    fun asteroidCollision(asteroids: IntArray): IntArray {
        val stack = Stack<Int>()
        looper@ for (aster in asteroids) {
            if (stack.isEmpty()) {
                stack.push(aster)
                continue@looper
            }
            while (stack.isNotEmpty() && stack.peek() > 0 && aster < 0) {
                if (-aster > stack.peek()) {
                    stack.pop()
                } else if (-aster == stack.peek()) {
                    stack.pop()
                    continue@looper
                } else {
                    continue@looper
                }
            }
            stack.push(aster)
        }
        val res = IntArray(stack.size)
        var index = stack.size - 1
        while (stack.isNotEmpty()) {
            res[index] = stack.pop()
            index--
        }
        return res
    }
}

fun main() {
    AsteroidCollision().asteroidCollision(intArrayOf(10,2,-5)).println()
}