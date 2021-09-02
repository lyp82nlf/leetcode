package string
//345. 反转字符串中的元音字母
class ConvertToTitle {
    var res = ""
    fun convertToTitle(columnNumber: Int): String {
        var n = columnNumber
        while (n > 0) {
            res += ((n - 1) % 26 + 65).toChar()
            n = (n - 1) / 26
        }
        return res.reversed()
    }
}

fun main() {
    print(ConvertToTitle().convertToTitle(52))
}