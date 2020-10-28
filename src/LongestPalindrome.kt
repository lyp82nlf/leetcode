import kotlin.math.max

class LongestPalindrome {
    /*
    给定一个字符串 s，找到 s 中最长的回文子串。你可以假设 s 的最大长度为 1000。

    示例 1：

    输入: "babad"
    输出: "bab"
    注意: "aba" 也是一个有效答案。
    示例 2：

    输入: "cbbd"
    输出: "bb"
    */
    /*
    * 1.中心扩散  不太想写这个 就是判断每一个点最大的回文数 算出start和end  判断max
    * 2.动态规划
    * */
    fun longestPalindrome(s: String): String {
        if (s.length <= 1) {
            return s
        }
        var arr = Array(s.length) { BooleanArray(s.length) }
        var charArr = s.toCharArray()
        for (i in 0..s.length - 1) {
            arr[i][i] = true
        }
        var maxLength: Int = 0
        var beginIndex: Int = 0
        for (right in 1..s.length - 1) {
            for (left in 0..right - 1) {
                if (charArr[left] != charArr[right]) {
                    arr[left][right] = false
                } else {
                    if (right - left < 3) {
                        arr[left][right] = true
                    } else {
                        arr[left][right] = arr[left + 1][right - 1]
                    }
                }

                if (arr[left][right] and (right - left + 1 > maxLength)) {
                    maxLength = right - left + 1
                    beginIndex = left
                }
            }
        }
        if (beginIndex == 0 && maxLength == 0) {
            return s.substring(0, 1)
        }
        return s.substring(beginIndex, beginIndex + maxLength)
    }

    fun isPalindrome(s: Int): Boolean {
        val s = s.toString()
        var result = true
        for (index in 0..s.length / 2) {
            if (s[index] != s[s.length - index - 1]) {
                result = false;
            }
        }
        return result
    }
}

fun main() {
    println(LongestPalindrome().longestPalindrome("aabaa"))
}