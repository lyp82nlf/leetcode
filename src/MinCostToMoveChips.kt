import Utils.println
import kotlin.math.min

/**
 * 1217. 玩筹码:wq
 */
class MinCostToMoveChips {
    fun minCostToMoveChips(position: IntArray): Int {
        var oddNumberSums = 0
        var evenNumberSums = 0
        for (value in position) {
            if (value %2 ==0){
                oddNumberSums++
            }else{
                evenNumberSums++
            }
        }
        return min(oddNumberSums,evenNumberSums)
    }
}

fun main() {
    MinCostToMoveChips().minCostToMoveChips(intArrayOf(2,2,2,3,3)).println()
}