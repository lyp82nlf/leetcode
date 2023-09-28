package array

class CaptureForts {
    fun captureForts(forts: IntArray): Int {
        var ans = 0
        var start = -1
        for ((index, fort) in forts.withIndex()) {
            if (fort != 0) {
                if (start >= 0 && forts[start] != fort) {
                    ans = Math.max(ans, index - start - 1)
                }
                start = index
            }
        }
        return ans
    }
}