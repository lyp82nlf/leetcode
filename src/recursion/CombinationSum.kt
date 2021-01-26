package recursion

class CombinationSum {
    fun combinationSum(candidates: IntArray, target: Int): List<List<Int>> {
        val result = mutableListOf<MutableList<Int>>()
        combinationSum(candidates, target, 0, mutableListOf(), result)
        return result
    }

    private fun combinationSum(candidates: IntArray, target: Int, start: Int, solution: MutableList<Int>, result: MutableList<MutableList<Int>>) {
        if (target < 0) {
            return
        }
        if (target == 0) {
            var element = mutableListOf<Int>()
            element.addAll(solution)
            result.add(element)
            return
        }
        for (i in start until candidates.size) {
            solution.add(candidates[i])
            combinationSum(candidates, target - candidates[i], i, solution, result)
            solution.removeAt(solution.lastIndex)
        }
    }
}

fun main() {
    CombinationSum().combinationSum(intArrayOf(2, 3, 6, 7), 7)
}