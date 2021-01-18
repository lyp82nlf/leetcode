package array

import java.util.*

class IsAnagram {
    fun isAnagram(s: String, t: String): Boolean {
        val res = arrayOfNulls<Int>(26)
        Arrays.fill(res, 0)
        for (sChar in s) {
            res[sChar - 'a'] = res[sChar - 'a']!! + 1
        }
        for (tChar in t) {
            res[tChar - 'a'] = res[tChar - 'a']!! - 1
        }
        for (char in res) {
            if (char != 0) {
                return false
            }
        }
        return true
    }
}