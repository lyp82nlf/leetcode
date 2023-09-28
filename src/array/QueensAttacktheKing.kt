package array

class QueensAttacktheKing {
    fun queensAttacktheKing(queens: Array<IntArray>, king: IntArray): List<List<Int>> {
        val direction = arrayOf(
            intArrayOf(-1, 0), intArrayOf(-1, 1), intArrayOf(0, 1), intArrayOf(1, 1),
            intArrayOf(1, 0), intArrayOf(1, -1), intArrayOf(0, -1), intArrayOf(-1, -1)
        )
        val ans = mutableListOf<List<Int>>()
        val queueArr = mutableSetOf<Int>()
        for (queue in queens) {
            queueArr.add(queue[0] * 8 + queue[1])
        }
        for (dir in direction) {
            val dx = dir[0]
            val dy = dir[1]
            var x = king[0]
            var y = king[1]
            while (x in 0..7 && y in 0..7) {
                if (queueArr.contains(x * 8 + y)) {
                    ans.add(listOf(x, y))
                    break
                }
                x += dx
                y += dy
            }
        }
        return ans
    }
}