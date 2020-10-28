fun main() {
    println(myPow(2.0, 11))
}

fun myPow(x: Double, n: Int): Double {
    if (n == 0) {
        return 1.0;
    }
    val isNegative = n < 0
    var result: Double
    val tmp = myPow(x, Math.abs(n / 2))
    if (n and 1 == 0) {
        //偶数
        result = tmp * tmp
    } else {
        //基数
        result = tmp * tmp * x
    }
    if (isNegative) {
        return 1 / result
    }
    return result
}

