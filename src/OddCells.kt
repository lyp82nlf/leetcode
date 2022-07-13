import Utils.print

//1252. 奇数值单元格的数目
class OddCells {
    fun oddCells(m: Int, n: Int, indices: Array<IntArray>): Int {
        val res = Array(m) { Array(n) { 0 } }
        for (indice in indices) {
            for (index in 0 until n) {
                res[indice[0]][index]++
            }
            for (index in 0 until m) {
                res[index][indice[1]]++
            }
        }
        var resNum = 0
        for (i in res.indices){
            for (j in res[i].indices){
                if (res[i][j] % 2 !=0){
                    resNum++
                }
            }
        }
        return resNum
    }
}

fun main() {
    OddCells().oddCells(2, 3, arrayOf(intArrayOf(0, 1), intArrayOf(1, 1))).print()
}