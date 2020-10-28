import Utils.TreeNode
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.lang.StringBuilder

class RecoverFromPreorder {
    fun recoverFromPreorder(S: String): TreeNode? {
        if (S.isEmpty()) {
            return null
        }
        var first = S[0]
        val root = TreeNode(first.toInt())
        var currentPrefix = "";
        return null
    }

    fun findLeftAndRightNodeString(s: String): StringArray {
        var deepth = StringBuilder()
        while (deepth.length < s.length && s[deepth.length] == '-') {
            deepth.append("-")
        }
        s.replace(deepth.toString(), "")
        var index = 0
        while (index < s.length - 1) {
            if (s[index] != '-' && s[index + 1] != '-') {
                break
            }
            index++
        }
        return StringArray()

    }


}