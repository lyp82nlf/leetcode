import Utils.TreeNode
import TreeNode.generateTreeNodeList

class MinDiffInBST {
    var list = mutableListOf<Int>()
    fun minDiffInBST(root: TreeNode?): Int {
        minDiffInBST1(root)
        var min = Int.MAX_VALUE
        var pre = -1
        for (i in list) {
            if (pre != -1) {
                if (i - pre < min) {
                    min = i - pre
                }
                pre = i
            }else{
                pre = i
            }
        }
        return min
    }

    fun minDiffInBST1(root: TreeNode?) {
        if (root == null) {
            return
        }
        minDiffInBST1(root.left)
        list.add(root.`val`)
        minDiffInBST1(root.right)
    }
}

fun main() {
    println(MinDiffInBST().minDiffInBST(generateTreeNodeList(arrayOf(90, 69, null, 49, 89, null, 52, null, null, null, null))))
}