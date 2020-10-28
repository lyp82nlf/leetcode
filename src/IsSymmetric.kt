import Utils.TreeNode

class IsSymmetric {
    fun isSymmetric(root: TreeNode?): Boolean {
        return isSame(root?.left, root?.right)
    }

    fun isSame(left: TreeNode?, right: TreeNode?): Boolean {
        if (left == null && right == null) {
            return true
        }
        if (left == null || right == null) {
            return false
        }

        if (left.`val` == right.`val`) {
            return isSame(left.left, right.right) && isSame(left.right, right.left)
        }
        return false
    }
}