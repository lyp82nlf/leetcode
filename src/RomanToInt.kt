class RomanToInt {
    fun romanToInt(s: String): Int {
        return romanToInt(s, 0)
    }

    private fun romanToInt(s: String, index: Int): Int {
        if (index >= s.length) {
            return 0
        }
        var firstChar = s[index]
        return when (firstChar) {
            'I' -> {
                return if (index + 1 < s.length && (s[index + 1] == 'V' || s[index + 1] == 'X')) {
                    getSpecialRomanInt(s[index + 1]) + romanToInt(s, index + 2)
                } else {
                    getIntFromRoman(firstChar) + romanToInt(s, index + 1)
                }
            }
            'X' -> {
                return if (index + 1 < s.length && (s[index + 1] == 'L' || s[index + 1] == 'C')) {
                    getSpecialRomanInt(s[index + 1]) + romanToInt(s, index + 2)
                } else {
                    getIntFromRoman(firstChar) + romanToInt(s, index + 1)
                }
            }
            'C' -> {
                return if (index + 1 < s.length && (s[index + 1] == 'D' || s[index + 1] == 'M')) {
                    getSpecialRomanInt(s[index + 1]) + romanToInt(s, index + 2)
                } else {
                    getIntFromRoman(firstChar) + romanToInt(s, index + 1)
                }
            }
            else -> getIntFromRoman(firstChar) + romanToInt(s, index + 1)
        }
    }

    private fun getSpecialRomanInt(secondChar: Char): Int {
        return when (secondChar) {
            'V' -> 4
            'X' -> 9
            'L' -> 40
            'C' -> 90
            'D' -> 400
            'M' -> 900
            else -> 0
        }
    }

    private fun getIntFromRoman(char: Char): Int =
            when (char) {
                'I' -> 1
                'V' -> 5
                'X' -> 10
                'L' -> 50
                'C' -> 100
                'D' -> 500
                'M' -> 1000
                else -> 0
            }
}

fun main() {
    println(RomanToInt().romanToInt("DCXXI"))
}