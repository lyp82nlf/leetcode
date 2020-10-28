class MinWindow {

    /*
    * 76. 最小覆盖子串
    * 给你一个字符串 S、一个字符串 T，请在字符串 S 里面找出：包含 T 所有字符的最小子串。
    * 示例：
    * 输入: S = "ADOBECODEBANC", T = "ABC"
    * 输出: "BANC"
    * 说明：
    * 如果 S 中不存这样的子串，则返回空字符串 ""。
    * 如果 S 中存在这样的子串，我们保证它是唯一的答案。
    * */
    /*
    * 明显滑动窗口问题  思考:什么时候应该使用滑动窗口?
    * 当我们需要找出最小区间 并且向右扩张没有意义 左边扩张解决最优解
    * */
    fun minWindow(s: String, t: String): String {
        if (t.isEmpty() || s.isEmpty()) {
            return ""
        }
        var needs: MutableMap<Char, Int> = mutableMapOf()
        var windows: MutableMap<Char, Int> = mutableMapOf()
        for (i in t) {
            needs.put(i, needs[i]?.plus(1) ?: 1)
        }
        var left = 0
        var right = 0
        var valid = 0
        var start = 0
        var len = Int.MAX_VALUE
        while (right < s.length) {
            var key = s[right]
            right++
            windows.put(key, windows[key]?.plus(1) ?: 1)
            if (windows[key] ?: 0 == needs[key] ?: 0) {
                valid++
            }
            while (valid == needs.size) {
                //左指针右移
                var key = s[left]
                if (right - left < len) {
                    start = left
                    len = right - left
                }
                left++
                windows.put(key, windows[key]!!.minus(1))
                if (windows[key] ?: 0 < needs[key] ?: 0) {
                    valid--
                }
            }
        }
        return if (len == Int.MAX_VALUE) "" else s.substring(start, start + len)
    }
}

fun main() {
    println(MinWindow().minWindow("ADOBECODEBANC", "ABC"))
}