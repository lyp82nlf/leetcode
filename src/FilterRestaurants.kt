import Utils.println
import java.util.*

class FilterRestaurants {
    fun filterRestaurants(
        restaurants: Array<IntArray>,
        veganFriendly: Int,
        maxPrice: Int,
        maxDistance: Int
    ): List<Int> {
        // 0 false 1 true
        val filterList = mutableListOf<IntArray>()
        for (restaurant in restaurants) {
            if (restaurant[2] >= veganFriendly && restaurant[3] <= maxPrice && restaurant[4] <= maxDistance) {
                filterList.add(restaurant)
            }
        }
        filterList.sortWith(Comparator { o1, o2 ->
            return@Comparator if (o1[1] == o2[1]) o2[0] - o1[0] else o2[1] - o1[1]
        })
        val ans = mutableListOf<Int>()
        for (filter in filterList) {
            ans.add(filter[0])
        }
        return ans
    }
}

fun main() {
    FilterRestaurants().filterRestaurants(
        arrayOf(
            intArrayOf(1,4,1,40,10),
            intArrayOf(2,8,0,50,5), intArrayOf(3,8,1,30,4), intArrayOf(4,10,0,10,3),
            intArrayOf(5,1,1,15,1)
        ), 0, 50, 10
    ).println()
}