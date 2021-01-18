package string

class LargeGroupPositions {
    fun largeGroupPositions(s: String): List<List<Int>> {
        if (s.isEmpty()) {
            return emptyList()
        }
        val res = mutableListOf<List<Int>>()
        var start = 0
        var end = 0
        var lastChar = s[0]
        for (ch in s.withIndex()) {
            if (ch.value != lastChar) {
                if (end - start >= 2) {
                    res.add(listOf(start, end))
                }
                start = ch.index
                end = ch.index
                lastChar = ch.value
            } else {
                end = ch.index
            }
        }
        if (end - start >= 2) {
            res.add(listOf(start, end))
        }
        return res
    }
}