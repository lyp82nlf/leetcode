class RepeatedSubstringPattern {
    fun repeatedSubstringPattern(s: String): Boolean {
        println((s + s).indexOf(s, 1))
        println(s.length)
        return (s + s).indexOf(s, 1) != s.length
    }
}

fun main() {
    println(RepeatedSubstringPattern().repeatedSubstringPattern("aaabbaaaabba"))
}

