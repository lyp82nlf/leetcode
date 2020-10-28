class SubarraysDivByK {
    /*
    * 给定一个整数数组 A，返回其中元素之和可被 K 整除的（连续、非空）子数组的数目。
    * 示例：
    * 输入：A = [4,5,0,-2,-3,1], K = 5
    * 输出：7
    * 解释：
    * 有 7 个子数组满足其元素之和可被 K = 5 整除：
    * [4, 5, 0, -2, -3, 1], [5], [5, 0], [5, 0, -2, -3], [0], [0, -2, -3], [-2, -3]
    * 提示：
    * 1 <= A.length <= 30000
    * -10000 <= A[i] <= 10000
    * 2 <= K <= 10000
    * */
    /*fun subarraysDivByK(A: IntArray, K: Int): Int {
        val prefixArray = Array<Int>(A.size + 1) { 0 }
        prefixArray[0] = 0
        var count = 0
        for (index in 1..A.size) {
            prefixArray[index] = prefixArray[index - 1] + A[index - 1]
        }

        for (index in 1..A.size) {
            for (i in 1..index) {
                if ((prefixArray[index] - prefixArray[i - 1]) % K == 0) {
                    count++
                }
            }
        }
        return count
    }*/
    fun subarraysDivByK(A: IntArray, K: Int): Int {
        val record = hashMapOf<Int, Int>()
        record[0] = 1
        var sum = 0
        for (i in A) {
            sum += i
            val modulus = (sum % K + K) % K
            record[modulus] = record.getOrDefault(modulus, 0) + 1
        }

        var ans = 0
        for ((key, value) in record) {
            ans += value * (value - 1) / 2
        }
        return ans
    }

}

fun main() {
    println(SubarraysDivByK().subarraysDivByK(intArrayOf(4, 5, 0, -2, -3, 1), 5))
}