import Utils.TreeNode
import kotlin.math.max

class Rob3 {
    fun rob(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var max1 = root.`val`
        if (root.left != null) max1 += (rob(root.left.left) + rob(root.left.right))
        if (root.right != null) max1 += (rob(root.right.left) + rob(root.right.right))
        return max(max1, rob(root.left) + rob(root.right))
    }
}