package BackTrack

import java.lang.StringBuilder

class SolveNQueens {
    private val columns = HashSet<Int>()
    private val diagonal1 = HashSet<Int>()
    private val diagonal2 = HashSet<Int>()

    fun solveNQueens(n: Int): List<List<String>> {
        val result = mutableListOf<MutableList<String>>()
        solveNQueens(n, 0, mutableListOf<String>(), result)
        return result
    }

    private fun solveNQueens(n: Int, row: Int, solution: MutableList<String>, result: MutableList<MutableList<String>>) {
        if (row > n) {
            return
        }
        if (row == n) {
            val mutableList = mutableListOf<String>()
            mutableList.addAll(solution)
            result.add(mutableList)
            return
        }

        for (i in 1..n) {
            if (canSolveQueen(row, i)) {
                solution.add(getQueenString(i, n))
                addSet(row, i)
                solveNQueens(n, row + 1, solution, result)
                remove(row, i)
                solution.removeAt(solution.lastIndex)
            } else {
                continue
            }
        }
    }

    private fun remove(row: Int, i: Int) {
        val plus = row + i
        val reduce = row - i
        columns.remove(i)
        diagonal1.remove(plus)
        diagonal2.remove(reduce)
    }

    private fun addSet(row: Int, i: Int) {
        val plus = row + i
        val reduce = row - i
        columns.add(i)
        diagonal1.add(plus)
        diagonal2.add(reduce)
    }


    private fun canSolveQueen(row: Int, i: Int): Boolean {
        val plus = row + i
        val reduce = row - i
        return !(columns.contains(i)
                || diagonal1.contains(plus)
                || diagonal2.contains(reduce))
    }


    private fun getQueenString(i: Int, n: Int): String {
        val base = StringBuilder()
        for (x in 1..n){
            base.append(".")
        }
        return base.substring(0, i - 1) + "Q" + base.substring(i, n)
    }
}

fun main() {
    print(SolveNQueens().solveNQueens(5))
}