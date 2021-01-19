package TreeNode

import Utils.TreeNode
import java.util.*

class KthSmallest {
    fun kthSmallest(root: TreeNode?, k: Int): Int {
        val stack = Stack<TreeNode>()
        var k = k
        var root = root
        while (stack.isNotEmpty() || root != null) {
            while (root != null) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            k--
            if (k == 0) {
                return root.`val`
            }
            root = root.right
        }
        return 0
    }
}