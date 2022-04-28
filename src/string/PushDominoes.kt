package string

import Utils.println

class PushDominoes {
    fun pushDominoes(dominoes: String): String {
        return ""
    }

    fun canPush(dominoes: String, index: Int): Boolean {
        var leftIndex = index - 1
        var rightIndex = index + 1
        loop@ while (leftIndex > 0) {
            when (dominoes[leftIndex]) {
                'L', 'D' -> {
                    break@loop
                }
                'R' -> {
                    return true
                }
            }
            leftIndex--
        }
        loop@ while (rightIndex < dominoes.length) {
            when (dominoes[rightIndex]) {
                'R', 'D' -> {
                    break@loop
                }
                'L' -> {
                    return true
                }
            }
            rightIndex++
        }
        return false
    }
}

fun main() {
    PushDominoes().canPush(".L.R...LR..L..", 2).println()
}