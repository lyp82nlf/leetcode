import Utils.TreeNode

class InvertTree {
    fun invertTree(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        var left = root.left
        root.left = root.right
        root.right = left
        invertTree(root.left)
        invertTree(root.right)
        return root
    }
}