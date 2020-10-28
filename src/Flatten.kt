import Utils.TreeNode

class Flatten {
    fun flatten(root: TreeNode?): Unit {
        if (root == null) {
            return
        }
        flatten(root.left)
        flatten(root.right)
        var tmpRight = root.right
        root.right = root.left
        root.left = null
        findLastRight(root).right = tmpRight
    }

    fun findLastRight(root: TreeNode): TreeNode {
        var root = root
        while (root.right != null) {
            root = root.right
        }
        return root

    }
}