package string

class WordPattern {
    fun wordPattern(pattern: String, s: String): Boolean {
        val map = mutableMapOf<Char, String>()
        val mapReverse = mutableMapOf<String, Char>()
        val split = s.split(" ")
        if (split.size != pattern.length) {
            return false
        }
        for ((index, p) in pattern.withIndex()) {
            if (mapReverse.get(split[index]) == null) {
                if (map.get(p) != null && map.get(p) != split[index]) {
                    return false
                }
                map.putIfAbsent(p, split[index])
                mapReverse.putIfAbsent(split[index], p)
            } else {
                if (mapReverse.get(split[index]) != p) {
                    return false
                }
            }
        }
        return true
    }
}

fun main() {
    WordPattern().wordPattern("abba","dog cat cat dog")
}