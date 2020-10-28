import Utils.TreeNode

class IsSubtree {
    fun isSubtree(s: TreeNode?, t: TreeNode?): Boolean {
        if (t == null) {
            return true
        }
        if (s == null) {
            return false
        }
        return isSubtree(s.left, t) || isSubtree(s.right, t) || isSame(s, t)

    }

    private fun isSame(s: TreeNode?, t: TreeNode?): Boolean {
        if (s == null && t == null) {
            return true
        }
        if (s == null || t == null) {
            return false
        }
        if (s.`val` != t.`val`) {
            return false
        }
        return isSame(s.left, t.left) && isSame(s.right, t.right)
    }
}