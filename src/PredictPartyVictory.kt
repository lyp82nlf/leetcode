import Utils.print

/**
 * 649. Dota2 参议院
 */
class PredictPartyVictory {
    // RDDRD
    fun predictPartyVictory(senate: String): String {
        if (!senate.contains("R")) {
            return "Dire"
        }
        if (!senate.contains("D")) {
            return "Radiant"
        }

        val senate = senate.toCharArray()
        for ((index, value) in senate.withIndex()) {
            if (value == 'N') {
                continue
            }
            if (value == 'R') {
                val findIndex = findIndex(senate, 'D', index)
                if (findIndex == -1) {
                    return "Radiant"
                }
                senate[findIndex] = 'N'
            } else if (value == 'D') {
                val findIndex = findIndex(senate, 'R', index)
                if (findIndex == -1) {
                    return "Dire"
                }
                senate[findIndex] = 'N'
            }
        }
        return predictPartyVictory(String(senate))
    }

    private fun findIndex(senate: CharArray, match: Char, index: Int): Int {
        var startIndex = if (index == senate.size - 1) {
            0
        } else {
            index + 1
        }
        while (startIndex != index) {
            if (senate[startIndex] == match) {
                return startIndex
            }
            if (startIndex == senate.size - 1) {
                startIndex = 0
            } else {
                startIndex++
            }
        }
        return -1
    }

}

//RNNNRNR
fun main() {
    PredictPartyVictory().predictPartyVictory("RDDRRDR").print()
}