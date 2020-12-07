package array

class SortArrayByParityII {
    fun sortArrayByParityII(A: IntArray): IntArray {
        var evenPoint = -1
        var oddPoint = -1
        val ans = IntArray(A.size)
        for (a in A.withIndex()) {
            if (a.index % 2 == 0) {
                //偶数
                evenPoint++
                while (evenPoint < A.size && A[evenPoint] % 2 != 0) {
                    evenPoint++
                }
                ans[a.index] = A[evenPoint]
            } else {
                //偶数
                oddPoint++
                while (oddPoint < A.size && A[oddPoint] % 2 == 0) {
                    oddPoint++
                }
                ans[a.index] = A[oddPoint]
            }
        }
        return ans
    }
}