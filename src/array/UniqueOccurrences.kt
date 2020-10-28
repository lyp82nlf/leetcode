package array

class UniqueOccurrences {
    fun uniqueOccurrences(arr: IntArray): Boolean {
        val map = mutableMapOf<Int, Int>()
        val set = mutableSetOf<Int>()
        for (i in arr) {
            map.put(i, map.getOrDefault(i, 0) + 1)
        }
        for (value in map.values) {
            set.add(value)
        }
        return set.size == map.size
    }
}