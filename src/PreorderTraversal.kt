import Utils.TreeNode
import java.util.*

class PreorderTraversal {
    fun preorderTraversal(root: TreeNode?): List<Int> {
        val ans = mutableListOf<Int>()
        if (root == null) {
            return ans
        }
        var root = root
        val stack = Stack<TreeNode>()
        while (stack.isNotEmpty() || root != null) {
            while (root != null) {
                ans.add(root.`val`)
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            root = root.right
        }
        return ans
    }
}