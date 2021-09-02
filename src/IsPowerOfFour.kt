class IsPowerOfFour {
    fun isPowerOfFour(n: Int): Boolean {
        var n: Float = n.toFloat()
        while (n >= 1) {
            if (n == 1f) {
                return true
            }
            n /= 4
        }
        return false
    }
}

fun main() {
    print(IsPowerOfFour().isPowerOfFour(16))
}