package prefixSum

import Utils.println
import java.util.*

class ChalkReplacer {
    fun chalkReplacer(chalk: IntArray, k: Int): Int {
        val prefix = IntArray(chalk.size)
        prefix[0] = chalk[0]
        for (i in 1 until chalk.size){
            prefix[i] = prefix[i-1] + chalk[i]
            if (prefix[i] > k){
                return i
            }
        }
        val sum = Arrays.stream(chalk).sum()
        var k = k
        if (k>sum){
            k %= sum
        }
        for (pre in prefix.withIndex()){
            if (pre.value>k){
                return pre.index
            }
        }
        return 0
    }
}

fun main() {
   ChalkReplacer().chalkReplacer(intArrayOf(59482),10737).println()
}