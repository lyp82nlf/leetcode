import Utils.TreeNode

class ConvertBiNode {
    //先序遍历转换为单链表
    var res: TreeNode? = null
    var tmp: TreeNode? = null

    fun convertBiNode(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        convertBiNode(root.left)
        var node = TreeNode(root.`val`)
        if (tmp == null) {
            res = node
            tmp = res
        } else {
            tmp!!.right = node
            tmp = tmp!!.right
        }
        convertBiNode(root.right)
        return res
    }

}