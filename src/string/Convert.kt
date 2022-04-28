package string

import Utils.println
import com.sun.xml.internal.fastinfoset.util.StringArray
import java.lang.StringBuilder

/**
 * 6. Z 字形变换
 */
class Convert {
    fun convert(s: String, numRows: Int): String {
        if (numRows == 1) {
            return s
        }
        val array = Array(numRows) { StringBuilder() }
        var currentRow = 0
        var direction = true
        for (ch in s) {
            array[currentRow].append(ch)
            if (currentRow == 0 && !direction) {
                currentRow++
                direction = true
            } else if (currentRow == numRows - 1) {
                direction = false
                currentRow--
            } else {
                currentRow = if (direction) currentRow + 1 else currentRow - 1
            }
        }
        val result = StringBuilder()
        for (index in array) {
            result.append(index.toString())
        }
        return result.toString()
    }
}

fun main() {
    Convert().convert("PAYPALISHIRING", 4).println()
}