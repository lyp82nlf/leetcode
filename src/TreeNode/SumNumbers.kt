package TreeNode

import Utils.TreeNode
import java.util.*

class SumNumbers {
    fun sumNumbers(root: TreeNode?): Int {
        return sumNumbers(root, 0)
    }

    fun sumNumbers(root: TreeNode?, prevSum: Int): Int {
        if (root == null) {
            return 0
        }
        var sum = prevSum * 10 + root.`val`
        if (root.left == null && root.right == null) {
            return sum
        }
        return sumNumbers(root.left, sum) + sumNumbers(root.right, sum)
    }
}

fun main() {
    SumNumbers().sumNumbers(generateTreeNodeList(arrayOf(4, 9, 0, 5, 1)))
}