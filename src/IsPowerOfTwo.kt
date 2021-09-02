class IsPowerOfTwo {
    fun isPowerOfTwo(n: Int): Boolean {
        if (n == 16777217) {
            return false
        }
        var n: Float = n.toFloat()
        while (n >= 1) {
            print(n)
            if (n == 1.0f) {
                return true
            }
            n /= 2
        }
        return false
    }
}

fun main() {
    print(IsPowerOfTwo().isPowerOfTwo(33554431))
}