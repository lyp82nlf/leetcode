import kotlin.math.min

class CountBinarySubstrings {
    fun countBinarySubstrings(s: String): Int {
        var ans = 0
        var last = 0
        var count = 0
        var ptr = 0

        while (ptr < s.length) {
            var c = s[ptr]
            while (ptr < s.length && c == s[ptr]) {
                ptr++
                count++
            }
            ans += min(count, last)
            last = count
            count = 0
        }
        return ans
    }
}

fun main() {
    println(CountBinarySubstrings().countBinarySubstrings("00110"))
}