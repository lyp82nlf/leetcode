class New21Game {
    var count: Double = 0.0
    var paramsCount: Double = 0.0
    //    9   1   10
    fun new21Game(N: Int, K: Int, W: Int): Double {
        for (i in 1..W) {
            count++
            if (N >= i) {
                paramsCount++
                if (K > i) {
                    new21Game(N - i, K - i, W)
                }
            }
        }

        return paramsCount / count
    }
}

fun main() {
    println(New21Game().new21Game(21, 17, 10))
}