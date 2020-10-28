import Utils.ListNodeUtil.generateListNode
import Utils.TreeNode
import Utils.generateTreeNodeList
import kotlin.math.max

class FindMode {
    var arr = mutableListOf<Int>()
    fun findMode(root: TreeNode?): IntArray {
        treeRecursion(root)
        val res = mutableListOf<Int>()
        var current = 0
        var count = 0
        var maxCount = 0
        for (i in arr) {
            if (i == current) {
                count++
                maxCount = handleCount(count, maxCount, res, i)
            } else {
                count = 1
                current = i
                maxCount = handleCount(count, maxCount, res, i)
            }
        }
        return res.toIntArray()
    }

    private fun handleCount(count: Int, maxCount: Int, res: MutableList<Int>, i: Int): Int {
        var maxCount1 = maxCount
        if (count > maxCount1) {
            maxCount1 = count
            res.clear()
            res.add(i)
        } else if (count == maxCount1) {
            res.add(i)
        }
        return maxCount1
    }

    fun treeRecursion(root: TreeNode?) {
        if (root == null) {
            return
        }
        treeRecursion(root.left)
        arr.add(root.`val`)
        treeRecursion(root.right)
    }
}

fun main() {
    FindMode().findMode(generateTreeNodeList(arrayOf(1, null, 3)))
}
