package array

import Utils.println

class OrderedStream(n: Int) {
    private val maxSize = n + 1
    private val stringArray = Array(maxSize) {
        ""
    }
    var ptr = 1
    fun insert(idKey: Int, value: String): List<String> {
        stringArray[idKey] = value
        val res = mutableListOf<String>()
        if (idKey == ptr) {
            while (ptr < maxSize && stringArray[ptr].isNotEmpty()) {
                res.add(stringArray[ptr])
                ptr++
            }
        }
        return res
    }
}

fun main() {
    val os = OrderedStream(5)
    os.insert(3, "ccccc").println() // 插入 (3, "ccccc")，返回 []
    os.insert(1, "aaaaa").println() // 插入 (1, "aaaaa")，返回 ["aaaaa"]
    os.insert(2, "bbbbb").println() // 插入 (2, "bbbbb")，返回 ["bbbbb", "ccccc"]
    os.insert(5, "eeeee").println() // 插入 (5, "eeeee")，返回 []
    os.insert(4, "ddddd").println() // 插入 (4, "ddddd")，返回 ["ddddd", "eeeee"]

}