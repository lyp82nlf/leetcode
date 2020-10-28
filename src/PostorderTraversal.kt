import Utils.TreeNode
import java.util.*

class PostorderTraversal {
    fun postorderTraversal(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        postorderTraversalByRecursion(root, res)
        return res
    }

    private fun postorderTraversalByRecursion(root: TreeNode?, list: MutableList<Int>) {
        if (root == null) {
            return
        }
        postorderTraversalByRecursion(root.left, list)
        postorderTraversalByRecursion(root.right, list)
        list.add(root.`val`)
    }

    fun postorderTraversalByTraversal(root: TreeNode?): List<Int> {
        if (root == null) {
            return emptyList()
        }
        val ans = mutableListOf<Int>()
        var root = root
        var prev: TreeNode? = null
        val stack = Stack<TreeNode?>()
        while (stack.isNotEmpty() || root != null) {
            while (root != null) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            if (root!!.right == null || prev == root?.right) {
                //root没有right 或者root.right已经遍历过
                ans.add(root.`val`)
                prev = root
                root = null
            } else {
                stack.push(root)
                root = root.right
            }
        }
        return ans
    }

}