package recursion

class Hano {
    fun hano(A: Char, B: Char, C: Char, n: Int) {
        if (n == 0) {
            return
        }
        hano(A, C, B, n - 1)
        println("把$n 从 $A 移到$C")
        hano(B, A, C, n - 1)
    }

    fun hanota(A: List<Int>, B: List<Int>, C: List<Int>): Unit {
        hanota(A as MutableList<Int>, B as MutableList<Int>, C as MutableList<Int>, A.size)
    }

    fun hanota(A: MutableList<Int>, B: MutableList<Int>, C: MutableList<Int>, size: Int): Unit {
        if (size == 0) {
            return
        }
        hanota(A, C, B, size - 1)
        C.add(A.removeAt(A.size-1))
        hanota(B,A,C,size-1)
    }
}

fun main() {
    Hano().hano('A', 'B', 'C', 3)
    Hano().hanota(mutableListOf(1,2,3), mutableListOf(), mutableListOf())
}