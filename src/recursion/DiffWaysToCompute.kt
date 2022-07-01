package recursion

import Utils.println

/**
 * 241. 为运算表达式设计优先级
 */
class DiffWaysToCompute {
    fun diffWaysToCompute(expression: String): List<Int> {
        if (isNumeric(expression)) {
            return listOf(expression.toInt())
        }
        val res = mutableListOf<Int>()
        for (index in expression.indices) {
            if (!isNumeric(expression[index].toString())){
                val leftList = diffWaysToCompute(expression.substring(0, index))
                val rightList = diffWaysToCompute(expression.substring(index + 1, expression.length))
                for (left in leftList) {
                    for (right in rightList) {
                        when (expression[index]) {
                            '+' -> res.add(left + right)
                            '-' -> res.add(left - right)
                            '*' -> res.add(left * right)
                        }
                    }
                }
            }
        }
        return res
    }

    fun isNumeric(toCheck: String): Boolean {
        return toCheck.toDoubleOrNull() != null
    }
}


fun main() {
    DiffWaysToCompute().diffWaysToCompute("2*3-4*5").println()
}