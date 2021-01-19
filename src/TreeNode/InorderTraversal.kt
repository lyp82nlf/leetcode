package TreeNode

import Utils.TreeNode
import java.util.*

class InorderTraversal {
    fun inorderTraversal(root: TreeNode?): List<Int> {
        var ans = mutableListOf<Int>()
        if (root == null) {
            return ans
        }
        ans.addAll(inorderTraversal(root.left))
        ans.add(root.`val`)
        ans.addAll(inorderTraversal(root.right))
        return ans
    }

    fun inorderTraversalIteration(root: TreeNode?): List<Int> {
        var root = root
        var stack = Stack<TreeNode?>()
        var ans = mutableListOf<Int>()

        while (root != null || !stack.empty()) {
            while (root != null) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            ans.add(root!!.`val`)
            root = root.right
        }
        return ans
    }

    fun inorderTraversalOneDay(root: TreeNode?): List<Int> {
        val res = mutableListOf<Int>()
        if (root == null) {
            return res
        }
        val stack = Stack<TreeNode>()
        var root = root
        while (root != null || !stack.isEmpty()) {
            while (root != null) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            res.add(root.`val`)
            root = root.right
        }
        return res
    }

    fun inOrderTraversalTwoDay(root: TreeNode): List<Int> {
        val res = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var root = root
        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            res.add(root.`val`)
            root = root.right
        }
        return res
    }

    fun inOrderTraversalThirdDay(root: TreeNode): List<Int> {
        val res = mutableListOf<Int>()
        val stack = Stack<TreeNode>()
        var root:TreeNode? = root
        while (stack.isNotEmpty() || root != null) {
            while (root != null) {
                stack.push(root)
                root = root.left
            }
            root = stack.pop()
            res.add(root.`val`)
            root = root.right
        }
        return res
    }

}

fun main() {
    InorderTraversal().inorderTraversalOneDay(generateTreeNodeList(arrayOf(1, null, 2, 3)))
}