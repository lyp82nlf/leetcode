import Utils.TreeNode
import java.util.*
import kotlin.math.min

class GetMinimumDifference {
    var minRes = Int.MAX_VALUE
    fun getMinimumDifference(root: TreeNode?): Int {
        getMinimumDifferenceByRecurision(root)
        return minRes
    }

    fun getMaxValueByLeftDirection(root: TreeNode?): Int {
        var root: TreeNode? = root ?: return 0
        while (root!!.right != null) {
            root = root.right
        }
        return root.`val`
    }

    fun getMinValueByRightDirection(root: TreeNode?): Int {
        var root: TreeNode? = root ?: return 0
        while (root!!.left != null) {
            root = root.left
        }
        return root.`val`
    }

    fun getMinimumDifferenceByRecurision(root: TreeNode?) {
        if (root == null) {
            return
        }
        root.left?.let {
            minRes = min(minRes, root.`val` - getMaxValueByLeftDirection(it))
        }
        root.right?.let {
            minRes = min(minRes, getMinValueByRightDirection(it) - root.`val`)
        }
        if (minRes == 1) {
            return
        }
        getMinimumDifferenceByRecurision(root.left)
        getMinimumDifferenceByRecurision(root.right)
    }

}