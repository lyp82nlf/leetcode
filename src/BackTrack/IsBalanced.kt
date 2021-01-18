package BackTrack

import Utils.TreeNode
import kotlin.math.abs
import kotlin.math.max

class IsBalanced {
    fun isBalanced(root: TreeNode?): Boolean {
        if (root == null) {
            return true
        }
        return abs(isBalanced(root?.left, 0) - isBalanced(root?.right, 0)) < 2 && isBalanced(root.left) && isBalanced(root.right)
    }

    fun isBalanced(root: TreeNode?, maxNum: Int): Int {
        if (root == null) {
            return maxNum
        }
        return max(isBalanced(root.left, maxNum + 1), isBalanced(root.right, maxNum + 1))
    }
}