package Utils

import java.lang.StringBuilder

operator fun String.times(other: Int): String {
    var index = other
    val res = StringBuilder()
    while (index > 0) {
        res.append(this)
        index--
    }
    return res.toString()
}