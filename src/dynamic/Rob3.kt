package dynamic

import Utils.ListNodeUtil
import Utils.TreeNode
import Utils.println
import java.util.*
import java.util.concurrent.LinkedBlockingDeque
import kotlin.math.max

//337. 打家劫舍 III
//
class Rob3 {
    val f = mutableMapOf<TreeNode?, Int>() // 选中某个点 f(o) = val + g(l) + g(r)
    val g = mutableMapOf<TreeNode?, Int>() // 不选中某个点 g(0) = max(f(l),g(l)) + max (f(r),g(r))
    fun rob(root: TreeNode?): Int {
        dfs(root)
        return Math.max(f.getOrDefault(root,0),g.getOrDefault(root,0))
    }

    fun dfs(node: TreeNode?) {
        if (node == null) {
            return
        }
        dfs(node.left)
        dfs(node.right)
        f.put(node, node.`val` + g.getOrDefault(node.left, 0) + g.getOrDefault(node.right, 0))
        g.put(
            node,
            Math.max(f.getOrDefault(node.left, 0), g.getOrDefault(node.left, 0)) + Math.max(
                f.getOrDefault(
                    node.right,
                    0
                ), g.getOrDefault(node.right, 0)
            )
        )
    }
}

fun main() {
    Rob3().rob(ListNodeUtil.arrayToTree(arrayOf(2, 1, 3, null, 4))).println()
}