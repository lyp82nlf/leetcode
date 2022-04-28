package array

import Utils.println

//398. 随机数索引
/**
 * 输入
["Solution", "pick", "pick", "pick"]
[[[1, 2, 3, 3, 3]], [3], [1], [3]]
输出
[null, 4, 0, 2]


来源：力扣（LeetCode）
链接：https://leetcode-cn.com/problems/random-pick-index
著作权归领扣网络所有。商业转载请联系官方授权，非商业转载请注明出处。
 */
class Pick(nums: IntArray) {
    val map: MutableMap<Int, MutableList<Int>> = mutableMapOf<Int, MutableList<Int>>()

    init {
        for (num in nums.withIndex()) {
            map.putIfAbsent(num.value, mutableListOf())
            map.get(num.value)!!.add(num.index)
        }
    }

    fun pick(target: Int): Int {
        return map.get(target)!!.random()
    }
}

fun main() {
    Pick(intArrayOf(1, 2, 3, 3, 3)).pick(3).println()
}