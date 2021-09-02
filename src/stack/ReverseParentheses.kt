package stack

import java.lang.StringBuilder
import java.util.*

/**
 * 1190. 反转每对括号间的子串
 */
class ReverseParentheses {
    fun reverseParentheses(s: String): String {
        val stack = Stack<String>()
        var tmpStr = StringBuilder()
        for (ch in s) {
            when (ch) {
                '(' -> {
                    stack.push(tmpStr.toString())
                    tmpStr.clear()
                }
                ')' -> {
                    val s = stack.pop() + tmpStr.reverse().toString()
                    tmpStr.clear()
                    tmpStr.append(s)
                }
                else -> {
                    tmpStr.append(ch)
                }
            }
        }
        return tmpStr.toString()
    }
}

fun main() {
    val s = "((eqk((h))))"
    print(ReverseParentheses().reverseParentheses(s))
}