import Utils.TreeNode

class ConvertBST {
    /*
    *   2
    * 0   3
   -4   1
    * */
    private var sum = 0
    fun convertBST(root: TreeNode?): TreeNode? {
        if (root == null) {
            return null
        }
        convertBST(root.right)
        sum += root.`val`
        root.`val` = sum
        convertBST(root.left)
        return root
    }
}