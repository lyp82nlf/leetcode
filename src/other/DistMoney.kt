package other

import Utils.println

class DistMoney {
    fun distMoney(money: Int, children: Int): Int {
        if (money < children) {
            return -1
        }
        if (money < (children + 7)) {
            return 0
        }
        //每人先分一块
        var money = money - children
        var ans = 0
        while (money >= 7 && ans < children) {
            ans++
            money -= 7
        }
        return if ((children == ans && money > 0) || (money == 3 && children - ans == 1)) {
            ans - 1
        } else {
            ans
        }
    }
}

fun main() {
    DistMoney().distMoney(23, 2).println()
}