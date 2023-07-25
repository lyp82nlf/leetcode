package dfs

import TreeNode.generateTreeNodeList
import Utils.TreeNode
import Utils.println
import kotlin.math.max
import kotlin.math.min

class BtreeGameWinningMove {
    fun btreeGameWinningMove(root: TreeNode?, n: Int, x: Int): Boolean {
        return if (x == 1) {
            var yNodeSize = 0
            val leftNodeSize = getTreeNodeSize(root?.left)
            val rightNodeSize = getTreeNodeSize(root?.right)
            yNodeSize = max(leftNodeSize, rightNodeSize)
            yNodeSize > min(leftNodeSize, rightNodeSize) + 1
        } else {
            val leftNode = findTreeNode(root, x)
            val rootLength = getTreeNodeSize(root)
            val leftNodeLength = getTreeNodeSize(leftNode)
            val leftChildLeftLength = getTreeNodeSize(leftNode?.left)
            val leftChildRightLength = getTreeNodeSize(leftNode?.right)
            rootLength - leftNodeLength > leftNodeLength || leftChildLeftLength > rootLength - leftChildLeftLength || leftChildRightLength > rootLength - leftChildRightLength
        }
    }

    fun getTreeNodeSize(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        return 1 + getTreeNodeSize(root.left) + getTreeNodeSize(root.right)
    }

    fun findTreeNode(root: TreeNode?, x: Int): TreeNode? {
        if (root == null) {
            return null
        }
        if (root.`val` == x) {
            return root
        }
        val left = findTreeNode(root.left, x)
        if (left != null) {
            return left
        }
        return findTreeNode(root.right, x)
    }

}

fun main() {
    BtreeGameWinningMove().btreeGameWinningMove(generateTreeNodeList(arrayOf(1, 2, 3, 4, 5)), 5, 2).println()
}