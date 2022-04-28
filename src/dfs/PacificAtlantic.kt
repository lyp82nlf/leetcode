package dfs

import Utils.println

/**
 * 417. 太平洋大西洋水流问题
 */
class PacificAtlantic {
    // 左上右下
    val px = intArrayOf(-1, 0, 1, 0)
    val py = intArrayOf(0, -1, 0, 1)
    var rows: Int = 0
    var cols: Int = 0
    lateinit var heights: Array<IntArray>

    fun pacificAtlantic(heights: Array<IntArray>): List<List<Int>> {
        rows = heights.size
        cols = heights[0].size
        this.heights = heights
        val pacific = Array(rows) {
            BooleanArray(cols) {
                false
            }
        }
        val atlantic = Array(rows) {
            BooleanArray(cols) {
                false
            }
        }
        //从左上右下 进行深度优先遍历
        for (row in 0 until rows) {
            dfs(row, 0, pacific)
        }
        //上
        for (col in 1 until cols) {
            dfs(0, col, pacific)
        }
        //右
        for (row in 0 until rows) {
            dfs(row, cols - 1, atlantic)
        }
        //下
        for (col in 0 until (cols - 1)) {
            dfs(rows - 1, col, atlantic)
        }
        val res = ArrayList<List<Int>>()
        for (row in 0 until rows) {
            for (col in 0 until cols) {
                if (pacific[row][col] && atlantic[row][col]) {
                    res.add(listOf(row, col))
                }
            }
        }
        return res
    }

    fun dfs(x: Int, y: Int, pacific: Array<BooleanArray>) {
        if (pacific[x][y]) {
            return
        }
        pacific[x][y] = true
        for (times in 0..3) {
            val newRow = x + px[times]
            val newCol = y + py[times]
            if (newRow >= 0 && newCol >= 0 && newRow < heights.size && newCol < heights[0].size && heights[newRow][newCol] >= heights[x][y]) {
                dfs(newRow, newCol, pacific)
            }
        }
    }

}
//2 1
//1 2
// [[0,4],[1,3],[1,4],[2,2],[3,0],[3,1],[4,0]]
fun main() {
    PacificAtlantic().pacificAtlantic(
        arrayOf(
            intArrayOf(1,2,2,3,5),
            intArrayOf(3,2,3,4,4),
            intArrayOf(2,4,5,3,1),
            intArrayOf(6,7,1,4,5),
            intArrayOf(5,1,1,2,4)
        )
    ).println()
}