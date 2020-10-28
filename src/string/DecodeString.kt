package string

import java.lang.StringBuilder

class DecodeString {

    /*
    * 给定一个经过编码的字符串，返回它解码后的字符串。
    * 编码规则为: k[encoded_string]，表示其中方括号内部的 encoded_string 正好重复 k 次。注意 k 保证为正整数。
    *
    * 你可以认为输入字符串总是有效的；输入字符串中没有额外的空格，且输入的方括号总是符合格式要求的。
    *
    * 此外，你可以认为原始数据不包含数字，所有的数字只表示重复的次数 k ，例如不会出现像 3a 或 2[4] 的输入。
    *
    * 示例:
    *
    * s = "3[a]2[bc]", 返回 "aaabcbc".
    * s = "3[a2[c]]", 返回 "accaccacc".
    * s = "2[abc]3[cd]ef", 返回 "abcabccdcdcdef".
    *
    * */
    fun decodeString(s: String): String {
        if (!s.contains('[')) {
            return s
        }
        var index = 0
        var result = StringBuilder()
        var times = StringBuilder()
        var tmpString = StringBuilder()
        var startIndex = 0
        var symbolCount = 0
        while (index < s.length) {
            if (s[index] == '[') {
                if (symbolCount == 0) {
                    startIndex = index + 1
                }
                symbolCount++
            } else if (s[index] in 'a'..'z') {
                if (symbolCount == 0) {
                    tmpString.append(s[index])
                }
            } else if (s[index] == ']') {
                symbolCount--
                if (symbolCount == 0) {
                    result.append(tmpString.toString())
                    result.append(generateTimesOfString(times.toString(), decodeString(s.substring(startIndex, index))))
                    result.append(decodeString(s.substring(index + 1, s.length)))
                    return result.toString()
                }
            } else {
                if (symbolCount == 0) {
                    times.append(s[index])
                }
            }
            index++
        }

        result.append(tmpString)
        return result.toString()
    }

    fun generateTimesOfString(times: String, string: String): String {
        if (times == "" || times == "0") {
            return ""
        }
        var sb = StringBuilder()
        for (i in 0 until times.toInt()) {
            sb.append(string)
        }
        return sb.toString();
    }
}

fun main() {
    println(DecodeString().decodeString("3[a]2[b4[F]c]"))
}