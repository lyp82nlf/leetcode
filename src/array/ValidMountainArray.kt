package array

class ValidMountainArray {
    fun validMountainArray(A: IntArray): Boolean {
        if (A.isEmpty()) {
            return false
        }
        var prevDir = 0 //0 默认 1 up  2down
        var prev = A[0]
        for (a in A) {
            if (a > prev) {
                if (prevDir == 2) {
                    return false
                }
                prevDir = 1
            } else {
                if (prevDir == 0) {
                    return false
                }
                prevDir = 2
            }
            prev = a
        }
        return prevDir == 2
    }
}