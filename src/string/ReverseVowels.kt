package string

class ReverseVowels {
    fun reverseVowels(s: String): String {
        val ch = s.toCharArray()
        var l = 0
        var r = s.length - 1
        val yy = charArrayOf('a', 'e', 'i', 'o', 'u','A','E','I','O','U')
        while (l < r) {
            if (yy.contains(ch[l]) && yy.contains(ch[r])) {
                val tmp = ch[l]
                ch[l] = ch[r]
                ch[r] = tmp
                l++
                r--
            } else if (yy.contains(ch[l]) && !yy.contains(ch[r])) {
                r--
            } else if (!yy.contains(ch[l]) && yy.contains(ch[r])) {
                l++
            } else {
                l++
                r--
            }
        }
        return String(ch)
    }
}

fun main() {
    print(ReverseVowels().reverseVowels("aA"))
}