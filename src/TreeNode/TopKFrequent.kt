package TreeNode

import java.util.*

class TopKFrequent {
    fun topKFrequent(nums: IntArray, k: Int): IntArray {
        val tmpMap = mutableMapOf<Int, Int>()
        for (num in nums) {
            tmpMap[num] = tmpMap.getOrDefault(num, 0) + 1
        }

        val priority = PriorityQueue<Bean>(nums.size
                , kotlin.Comparator { o1, o2 -> o1.times - o2.times })
        for (item in tmpMap) {
            priority.offer(Bean(item.key, item.value))
        }
        val res = IntArray(k)
        for (i in 0 until k) {
            res[i] = priority.poll().num
        }
        return res
    }

    data class Bean(val num: Int, val times: Int)
}