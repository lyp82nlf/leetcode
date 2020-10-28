class ValidPalindrome {
    /*
    * 给定一个非空字符串 s，最多删除一个字符。判断是否能成为回文字符串。
    * 示例 1:
    * 输入: "aba"
    * 输出: True
    * 示例 2:
    * 输入: "abca"
    * 输出: True
    * 解释: 你可以删除c字符。
    * */
    /*
    * 第一眼:左后指针
    * */
    fun validPalindrome(s: String): Boolean {

        return validPalindrome(s, 0, s.length - 1, 1)
    }

    fun validPalindrome(s: String, left: Int, right: Int, remainCount: Int): Boolean {
        if (left >= right) {
            return true
        }
        if (s[left] != s[right]) {
            if (remainCount == 0) {
                return false
            } else {
                return validPalindrome(s, left + 1, right, remainCount - 1) or validPalindrome(s, left, right - 1, remainCount - 1)
            }
        } else {
            return validPalindrome(s, left + 1, right - 1, remainCount)
        }
    }

}

fun main() {
    println(ValidPalindrome().validPalindrome("abcbaaa"))
}