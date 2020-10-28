package string

import kotlin.math.max

class PartitionLabels {
    fun partitionLabels(S: String): List<Int> {
        val res = mutableListOf<Int>()
        partitionLabels(S, 0, S.length, res)
        return res
    }


    fun partitionLabels(s: String, firstIndex: Int, endIndex: Int, res: MutableList<Int>) {
        if (endIndex <= firstIndex) {
            return
        }
        var maxIndex = s.lastIndexOf(s[firstIndex])
        if (maxIndex == -1) {
            res.add(1)
            partitionLabels(s, firstIndex + 1, endIndex, res)
            return
        }
        var i = firstIndex
        while (i <= maxIndex) {
            maxIndex = max(maxIndex, s.lastIndexOf(s[i]))
            i++
        }
        res.add(maxIndex - firstIndex + 1)
        partitionLabels(s, maxIndex + 1, endIndex, res)
    }
}

fun main() {
    PartitionLabels().partitionLabels("ababcbacadefegdehijhklij")
}