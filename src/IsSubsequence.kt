class IsSubsequence {
    fun isSubsequence(s: String, t: String): Boolean {
        if (s.isEmpty()) {
            return true
        }
        if (t.isEmpty()) {
            return false
        }
        var index = 0
        for (st in t) {
            if (st == s[index]) {
                if (index + 1 == s.length) {
                    return true
                }
                index++
            }
        }
        return false
    }
}

fun main() {
    println("${IsSubsequence().isSubsequence("aec", "ahbgdc")}")
}