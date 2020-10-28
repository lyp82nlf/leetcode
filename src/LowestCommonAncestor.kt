import Utils.TreeNode

class LowestCommonAncestor {
    fun lowestCommonAncestor(root: TreeNode?, p: TreeNode?, q: TreeNode?): TreeNode? {
        if (p == q) {
            return p
        }
        var p = p
        var q = q
        if (p!!.`val`>q!!.`val`){
            val tmp = p
            p = q
            q = tmp
        }
        if (root == null) {
            return null
        }
        //分别左右节点
        if (p!!.`val` < root.`val` && q!!.`val` > root.`val`) {
            return root
        }
        if (p.`val` == root.`val`) {
            return p
        }
        if (q!!.`val` == root.`val`) {
            return q
        }
        //都在左边
        if (p.`val` < root.`val` && q.`val` < root.`val`) {
            return lowestCommonAncestor(root.left, p, q)
        }
        //都在右边
        return lowestCommonAncestor(root.right, p, q)
    }
}