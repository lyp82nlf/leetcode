import Utils.TreeNode

class InsertIntoBST {
    fun insertIntoBST(root: TreeNode?, `val`: Int): TreeNode? {
        if (root == null) {
            return TreeNode(`val`)
        }
        val ans = root
        var root = root
        while (root != null) {
            if (root.`val` < `val`) {
                if (root.right != null) {
                    root = root.right
                } else {
                    root.right = TreeNode(`val`)
                    root = null
                }
            } else {
                if (root.left != null) {
                    root = root.left
                } else {
                    root.left = TreeNode(`val`)
                    root = null
                }
            }
        }
        return ans
    }
}