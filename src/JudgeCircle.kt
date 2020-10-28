class JudgeCircle {
    fun judgeCircle(moves: String): Boolean {
        var rowCount = 0
        var colCount = 0
        for (move in moves) {
            when (move) {
                'L' -> rowCount--
                'R' -> rowCount++
                'D' -> colCount--
                'U' -> colCount++
            }
        }
        return rowCount == 0 && colCount == 0
    }
}