import kotlin.math.max

class MaxScoreSightseeingPair {
    fun maxScoreSightseeingPair(A: IntArray): Int {
        var maxI = A[0] + 0
        var ans = 0
        for (jIndex in 1 until A.size) {
            ans = max(ans, maxI + A[jIndex] - jIndex)
            maxI = max(maxI, A[jIndex] + jIndex)
        }
        return ans
    }
}

fun main() {

}