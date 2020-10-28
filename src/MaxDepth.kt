import Utils.TreeNode
import kotlin.math.max

class MaxDepth {
    fun maxDepth(root: TreeNode?): Int {
        return if (root == null) 0 else max(maxDepth(root.left), maxDepth(root.right)) + 1
    }
}