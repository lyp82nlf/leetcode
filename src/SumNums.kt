class SumNums {
    /*
    * 求 1+2+...+n ，要求不能使用乘除法、for、while、if、else、switch、case等关键字及条件判断语句（A?B:C）。
    * 示例 1：
    *
    * 输入: n = 3
    * 输出: 6
    * 示例 2：
    *
    * 输入: n = 9
    * 输出: 45
    * */
    var res = 0

    fun sumNums(n: Int): Int {
        n > 1 && sumNums(n - 1) > 0
        res += n
        return res
    }
}

fun main() {
    println(SumNums().sumNums(3))
}