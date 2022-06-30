import Utils.println

class NumPrimeArrangements {
    val primeNumList = BooleanArray(100)
    val MOD:Long = (1e9+7).toLong()
    init {
        loop@ for (i in 2..99) {
            var n = 2
            while (n * n <= i) {
                if (i % n == 0) {
                    continue@loop
                }
                n++
            }
            primeNumList[i-1] = true
        }
    }

    fun numPrimeArrangements(n: Int): Int {
        var primeSum = 0
        var nonPrimeSum = 0
        for (index in 0 until n) {
            if (primeNumList[index]){
                primeSum++
            }else{
                nonPrimeSum++
            }
        }
        var ans = 1L
        while (primeSum>1){
            ans = (primeSum*ans) % MOD
            primeSum--
        }
        while (nonPrimeSum>1){
            ans = (nonPrimeSum*ans) % MOD
            nonPrimeSum--
        }
        return ans.toInt()
    }
}

fun main() {
    NumPrimeArrangements().numPrimeArrangements(100).println()
}