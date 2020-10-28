package string

import java.util.*

class BackspaceCompare {
    fun backspaceCompare(S: String, T: String): Boolean {
        val s = Stack<Char>()
        val t = Stack<Char>()
        for (i in S) {
            if (i == '#') {
                if (!s.isEmpty()) s.pop()
                continue
            }
            s.push(i)
        }
        for (i in T) {
            if (i == '#') {
                if (!t.isEmpty()) t.pop()
                continue
            }
            t.push(i)
        }
        while (!s.isEmpty() && !t.isEmpty()) {
            if (s.pop() != t.pop()) {
                return false
            }
        }
        return s.size == t.size
    }
}

fun main() {
    BackspaceCompare().backspaceCompare("ab##", "a#b#")
}