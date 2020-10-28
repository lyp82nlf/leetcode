class DivingBoard {
    var res = arrayListOf<Int>()

    fun divingBoard(shorter: Int, longer: Int, k: Int): IntArray {
        if (k == 0) {
            return IntArray(0)
        }
        if (shorter == longer) {
            return IntArray(1) {
                shorter * k
            }
        }
        divingBoard(shorter, longer, k, 0)
        return res.toIntArray()
    }

    fun divingBoard2(shorter: Int, longer: Int, k: Int): IntArray {
        if (k == 0) {
            return IntArray(0)
        }
        if (shorter == longer) {
            return IntArray(1) {
                shorter * k
            }
        }
        for (i in 1..k) {
            res.add(i * shorter + (k - i) * longer)
        }
        return res.toIntArray()
    }

    fun divingBoard(shorter: Int, longer: Int, k: Int, sum: Int) {
        if (k == 0) {
            !res.contains(sum) && res.add(sum)
            return
        }
        divingBoard(shorter, longer, k - 1, sum + shorter)
        divingBoard(shorter, longer, k - 1, sum + longer)
    }
}

fun main() {
    DivingBoard().divingBoard2(1, 1, 10000).print()
}
