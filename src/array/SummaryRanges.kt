package array

class SummaryRanges {
    fun summaryRanges(nums: IntArray): List<String> {
        if (nums.isEmpty()){
            return mutableListOf()
        }
        val ans = mutableListOf<String>()
        var left = nums[0]
        var right = nums[0]
        var printRight = -1
        for (index in 1 until nums.size) {
            if (nums[index] - right == 1) {
                right = nums[index]
            } else {
                ans.add(getPrintF(left, right))
                printRight = right
                left = nums[index]
                right = nums[index]
            }
        }
        if (printRight == -1 || printRight != nums.last()) {
            ans.add(getPrintF(left, right))
        }
        return ans
    }

    fun getPrintF(a: Int, b: Int): String {
        return if (a==b) a.toString() else "$a->$b"
    }
}