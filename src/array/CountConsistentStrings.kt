package array

import kotlin.collections.HashSet

class CountConsistentStrings {
    fun countConsistentStrings(allowed: String, words: Array<String>): Int {
        val set = HashSet<Char>()
        var res = 0
        for (ch in allowed) {
            set.add(ch)
        }
        for (word in words) {
            if (set.containsAll(word.toCharArray().toList())){
                res++
            }
        }
        return res
    }
}