import Utils.println
import kotlin.math.min

/**
 * 575. 分糖果
 */
class DistributeCandies {
    fun distributeCandies(candyType: IntArray): Int {
        val map = mutableSetOf<Int>()
        for (type in candyType) {
            map.add(type)
        }
        return min(candyType.size / 2, map.size)
    }
}

fun main() {
    DistributeCandies().distributeCandies(intArrayOf(6,6,6,6)).println()
}