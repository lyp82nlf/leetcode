package array

import Utils.println

class CountValidWords {
    fun countValidWords(sentence: String): Int {
        val split = sentence.split(' ')
        var count = 0
        for (sp in split){
            if (isValid(sp)){
                count ++
            }
        }
        return count
    }

    private fun isValid(str: String): Boolean {
        if (str.trim().isEmpty()){
            return false
        }
        var hasPunctuation = false
        for (chIndex in str.withIndex()) {
            when (chIndex.value) {
                in '0'..'9' -> {
                    return false
                }
                '!', '.', ',' -> {
                    if (chIndex.index != str.length - 1) {
                        return false
                    }
                }
                '-' -> {
                    if (hasPunctuation || chIndex.index == 0 || chIndex.index == str.length -1 || str[chIndex.index -1] !in 'a'..'z' || str[chIndex.index + 1] !in 'a'..'z'){
                        return false
                    }
                    hasPunctuation = true
                }
            }
        }
        return true
    }
}

fun main() {
    CountValidWords().countValidWords("a-b-c").println()
}