package SlideWindow

import Utils.println

/**
 * 904. 水果成篮
 * fruits = [3,3,3,1,2,1,1,2,3,3,4]
 */
class TotalFruit {
    fun totalFruit(fruits: IntArray): Int {
        var left = 0
        var max = 0
        // 种类->数量
        val fruitsMap = HashMap<Int, Int>()
        for (right in fruits.indices) {
            fruitsMap[fruits[right]] = fruitsMap.getOrDefault(fruits[right], 0) + 1
            while (fruitsMap.keys.size > 2) {
                fruitsMap[fruits[left]] = fruitsMap.get(fruits[left])!! - 1
                if (fruitsMap[fruits[left]] == 0) {
                    fruitsMap.remove(fruits[left])
                }
                left++
            }
            max = Math.max(max, right - left + 1)
        }
        return max
    }
}

fun main() {
    TotalFruit().totalFruit(intArrayOf(3, 3, 3, 1, 2, 1, 1, 2, 3, 3, 4)).println()
}