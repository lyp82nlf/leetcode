class SpiralOrder {
    fun spiralOrder(matrix: Array<IntArray>): IntArray {
        if (matrix.isEmpty()) {
            return IntArray(0)
        }
        var l = 0
        var r = matrix[0].size - 1
        var t = 0
        var b = matrix.size - 1
        var res = IntArray(matrix.size * matrix[0].size)
        var index = 0
        while (true) {
            for (i in l..r) {//往右
                res[index] = matrix[t][i]
                index++
            }
            t++
            if (t > b) break
            for (i in t..b) {//往下
                res[index] = matrix[i][r]
                index++
            }
            r--
            if (r < l) break
            for (i in r downTo l) {//往左
                res[index] = matrix[b][i]
                index++
            }
            b--
            if (t > b) break
            for (i in b downTo t) {//往上
                res[index] = matrix[i][l]
                index++
            }
            l++
            if (r < l) break
        }
        return res
    }
}