package printer

import Utils.print

class NumRescueBoats {
    fun numRescueBoats(people: IntArray, limit: Int): Int {
        people.sort()
        var l = 0
        var r = people.size - 1
        var res = 0
        while (l <= r) {
            if (limit - people[r] >= people[l]) {
                //可以带两人
                l++
            }
            r--
            res++
        }
        return res
    }
}

fun main() {
    NumRescueBoats().numRescueBoats(intArrayOf(3,5,3,4),5).print()
}