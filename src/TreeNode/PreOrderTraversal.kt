package TreeNode

import Utils.TreeNode
import java.util.*

class PreOrderTraversal {
    fun preOrderTraversal(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        if (root == null) {
            return res
        }
        var root = root
        val stack = Stack<TreeNode>()
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                res.add(root.`val`)
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            root = root.right
        }
        return res
    }
}