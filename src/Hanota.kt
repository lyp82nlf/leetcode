class Hanota {
    fun hanota(A: List<Int>, B: List<Int>, C: List<Int>): Unit {
        hanota(A.size, A.toMutableList(), B.toMutableList(), C.toMutableList())
    }

    fun hanota(size: Int, A: MutableList<Int>, B: MutableList<Int>, C: MutableList<Int>): Unit {
        if (size == 1) {
            C.addAll(A)
            return
        }
        hanota(size - 1, A, C, B)
        C.add(A[0])
        hanota(size - 1, B, C, A)
    }
}

fun main() {
    Hanota().hanota(listOf(1), emptyList(), emptyList())
}