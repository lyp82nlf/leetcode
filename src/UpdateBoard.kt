import java.lang.Exception

class UpdateBoard {
    fun updateBoard(board: Array<CharArray>, click: IntArray): Array<CharArray> {
        val xLength = board.size
        val yLength = board[0].size
        if (click[0] >= xLength || click[1] >= yLength || click[0] < 0 || click[1] < 0) {
            return board
        }
        when (board[click[0]][click[1]]) {
            'M' -> {
                board[click[0]][click[1]] = 'X'
            }
            'E' -> {
                val boardCount = checkBoard(board, click)
                if (boardCount == '0') {
                    board[click[0]][click[1]] = 'B'
                    updateBoard(board, intArrayOf(click[0] - 1, click[1]))
                    updateBoard(board, intArrayOf(click[0] + 1, click[1]))
                    updateBoard(board, intArrayOf(click[0], click[1] - 1))
                    updateBoard(board, intArrayOf(click[0], click[1] + 1))
                    updateBoard(board, intArrayOf(click[0] - 1, click[1] - 1))
                    updateBoard(board, intArrayOf(click[0] - 1, click[1] + 1))
                    updateBoard(board, intArrayOf(click[0] + 1, click[1] - 1))
                    updateBoard(board, intArrayOf(click[0] + 1, click[1] + 1))

                    return board
                }
                board[click[0]][click[1]] = boardCount
            }
        }
        return board
    }


    private fun checkBoard(board: Array<CharArray>, click: IntArray): Char {
        var count = 0
        try {
            if (board[click[0] - 1][click[1]] == 'M') {
                count += 1
            }
        } catch (e: Exception) {
        }

        try {
            if (board[click[0] + 1][click[1]] == 'M') {
                count += 1
            }
        } catch (e: Exception) {
        }

        try {
            if (board[click[0]][click[1] - 1] == 'M') {
                count += 1
            }
        } catch (e: Exception) {
        }

        try {
            if (board[click[0]][click[1] + 1] == 'M') {
                count += 1
            }
        } catch (e: Exception) {
        }
        try {
            if (board[click[0] - 1][click[1] - 1] == 'M') {
                count += 1
            }
        } catch (e: Exception) {
        }
        try {
            if (board[click[0] + 1][click[1] - 1] == 'M') {
                count += 1
            }
        } catch (e: Exception) {
        }
        try {
            if (board[click[0] - 1][click[1] + 1] == 'M') {
                count += 1
            }
        } catch (e: Exception) {
        }
        try {
            if (board[click[0] + 1][click[1] + 1] == 'M') {
                count += 1
            }
        } catch (e: Exception) {
        }

        return (count + 48).toChar()
    }
}

fun main() {
    var result = arrayOf(
            charArrayOf('E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E', 'E', 'E', 'M'),
            charArrayOf('E', 'E', 'M', 'E', 'E', 'E', 'E', 'E'),
            charArrayOf('M', 'E', 'E', 'E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'E', 'E', 'E', 'E', 'E', 'E'),
            charArrayOf('E', 'E', 'M', 'M', 'E', 'E', 'E', 'E')
    )


    arrayOf(
            charArrayOf('B', 'B', 'B', 'B', 'B', 'B', '1', 'E'),
            charArrayOf('B', '1', '1', '1', 'B', 'B', '1', 'M'),
            charArrayOf('1', 'E', 'M', '1', 'B', 'B', '1', '1'),
            charArrayOf('M', 'E', '1', '1', 'B', 'B', 'B', 'B'),
            charArrayOf('1', '1', 'B', 'B', 'B', 'B', 'B', 'B'),
            charArrayOf('B', 'B', 'B', 'B', 'B', 'B', 'B', 'B'),
            charArrayOf('B', '1', '2', '2', '1', 'B', 'B', 'B'),
            charArrayOf('B', '1', 'M', 'M', '1', 'B', 'B', 'B')
    )
    println(UpdateBoard().updateBoard(result, intArrayOf(3, 0)))

}