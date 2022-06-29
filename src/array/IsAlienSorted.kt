package array

import Utils.println

class IsAlienSorted {
    fun isAlienSorted(words: Array<String>, order: String): Boolean {
        val orderMap = mutableMapOf<Char, Int>()
        for (ch in order.withIndex()) {
            orderMap[ch.value] = ch.index
        }
        var preWord = words[0]
        for (index in 1 until words.size) {
            val nowWord = words[index]
            for (compareIndex in preWord.indices) {
                if (compareIndex == nowWord.length){
                    return false
                }
                if (preWord[compareIndex] == nowWord[compareIndex]) {
                    continue
                } else if (orderMap[preWord[compareIndex]]!! < orderMap[nowWord[compareIndex]]!!) {
                    break
                } else {
                    return false
                }
            }
            preWord = nowWord
        }
        return true
    }
}

fun main() {
    IsAlienSorted().isAlienSorted(arrayOf("apple","app"), "abcdefghijklmnopqrstuvwxyz").println()
}