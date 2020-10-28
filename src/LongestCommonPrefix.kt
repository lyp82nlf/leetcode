class LongestCommonPrefix {
    fun longestCommonPrefix(strs: Array<String>): String {
        if (strs.size == 0) {
            return ""
        }
        if (strs.size == 1) {
            return strs[0]
        }
        val firstStr = strs[0]
        for (i in firstStr.length - 1 downTo 0) {
            var meetTheRequireMent = true
            var prefix = firstStr.substring(0..i)
            for (str in strs) {
                if (!str.startsWith(prefix)) {
                    meetTheRequireMent = false
                    break
                }
            }
            if (meetTheRequireMent) {
                return prefix
            }
        }
        return ""
    }
}

fun main() {
    println(LongestCommonPrefix().longestCommonPrefix(arrayOf("flower", "flow", "flight")))
}