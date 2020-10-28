import Utils.TreeNode

class IsSameTree {

    fun isSameTree(p: TreeNode?, q: TreeNode?): Boolean {
        if (p == null && q != null) {
            return false
        }
        if (p != null && q == null) {
            return false
        }
        if (p == null && q == null) {
            return true
        }
        if (p?.`val` == q?.`val`) {
            return isSameTree(p?.left, q?.left) && isSameTree(p?.right, q?.right)
        }
        return false
    }
}