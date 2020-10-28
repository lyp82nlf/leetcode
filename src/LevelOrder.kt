import Utils.TreeNode
import Utils.generateTreeNodeList
import java.util.*
import kotlin.collections.ArrayList

class LevelOrder {

    /*
    * 给你一个二叉树，请你返回其按 层序遍历 得到的节点值。 （即逐层地，从左到右访问所有节点）。
    * 示例:
    * 二叉树：[3,9,20,null,null,15,7],

    3
   / \
  9  20
    /  \
   15   7
   * 返回其层次遍历结果：
[
  [3],
  [9,20],
  [15,7]
]
    * */

    /**
     * Example:
     * var ti = Utils.TreeNode(5)
     * var v = ti.`val`
     * Definition for a binary tree node.
     * class Utils.TreeNode(var `val`: Int) {
     *     var left: Utils.TreeNode? = null
     *     var right: Utils.TreeNode? = null
     * }
     */
    fun levelOrder(root: TreeNode?): List<List<Int>> {
        var result = ArrayList<List<Int>>()
        var tmpList = ArrayList<Int>()
        if (root == null) return result
        var queue = ArrayDeque<Any>()
        queue.offer(root)
        queue.offer("-1")
        while (queue.isNotEmpty()) {
            var pop = queue.poll()
            if (pop is TreeNode) {
                tmpList.add(pop.`val`)
                if (pop.left != null) queue.offer(pop.left)
                if (pop.right != null) queue.offer(pop.right)
            } else {
                result.add(ArrayList(tmpList))
                if (!queue.isEmpty()) queue.offer("-1")
                tmpList.clear()
            }
        }
        return result
    }
}

fun main() {
    println(LevelOrder().levelOrder(generateTreeNodeList()))
}