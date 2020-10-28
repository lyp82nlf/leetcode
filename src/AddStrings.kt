import java.lang.StringBuilder

class AddStrings {
    fun addStrings(num1: String, num2: String): String {
        var num1 = num1
        var num2 = num2
        while (num1.length < num2.length) num1 = "0" + num1
        while (num1.length > num2.length) num2 = "0" + num2
        var ans = StringBuilder()
        var carry = 0
        for (i in num1.length - 1 downTo 0) {
            var tmp = num1[i] - '0' + (num2[i] - '0')+carry
            ans.insert(0, tmp.rem(10))
            carry = if (tmp >= 10) 1 else 0
        }
        if (carry == 1) {
            ans.insert(0, '1')
        }
        return ans.toString()
    }
}

fun main() {
    println(AddStrings().addStrings("123", "32139"))
}