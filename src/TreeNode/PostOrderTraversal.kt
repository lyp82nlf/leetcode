package TreeNode

import Utils.TreeNode
import java.util.*

class PostOrderTraversal {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        var root = root
        val stack = Stack<TreeNode>()
        val res = mutableListOf<Int>()
        var pre: TreeNode? = null
        while (stack.isNotEmpty() || root != null) {
            while (root != null) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            if (root.right != null && pre != root.right) {
                stack.push(root)
                root = root.right
            } else {
                res.add(root.`val`)
                pre = root
                //这里能有效避免进入左分支
                root = null
            }
        }
        return res
    }
}