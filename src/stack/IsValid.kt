package stack

import java.util.*

class IsValid {
    fun isValid(s: String): Boolean {
        var stack = Stack<Char>()
        for (char in s) {
            if (stack.isNotEmpty()) {
                val peek = stack.peek()
                if (isValidStr(char, peek)) {
                    stack.pop()
                } else {
                    stack.push(char)
                }
            } else {
                stack.push(char)
            }
        }
        return stack.isEmpty()
    }

    fun isValidStr(s1: Char, s2: Char): Boolean {
        when (s1) {
            '(' -> return s2 == ')'
            '{' -> return s2 == '}'
            '[' -> return s2 == ']'
        }
        return false
    }
}