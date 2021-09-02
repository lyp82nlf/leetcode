package array


class PickIndex(w: IntArray) {
    private var pre: IntArray = IntArray(w.size)
    var total = 0

    init {
        pre[0] = w[0]
        for (index in 1 until w.size) {
            pre[index] = pre[index - 1] + w[index]
        }
        total = pre.last()
    }

    fun pickIndex(): Int {
        return binarySearch((Math.random() * total).toInt() + 1)
    }

    private fun binarySearch(nextInt: Int): Int {
        if (nextInt <= pre[0]) {
            return 0
        }
        var l = 0
        var r = pre.size - 1
        var h = 0
        while (l < r) {
            h = (l + r + 1) / 2
            if (pre[h] == nextInt) {
                return h
            } else if (pre[h] > nextInt) {
                if (pre[h - 1] < nextInt) {
                    return h
                }
                r = h
            } else {
                l = h
            }
        }
        return h
    }
}

fun main() {
    val pickIndex = PickIndex(intArrayOf(5, 10, 10, 30))
    print(pickIndex.pickIndex())
    print(pickIndex.pickIndex())
    print(pickIndex.pickIndex())
    print(pickIndex.pickIndex())
    print(pickIndex.pickIndex())
}