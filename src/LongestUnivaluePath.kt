import Utils.TreeNode
import kotlin.math.max

class LongestUnivaluePath {
    var ans = 0
    fun longestUnivaluePath(root: TreeNode?): Int {
        longestPath(root)
        return ans
    }

    fun longestPath(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        var maxLength = 0
        val leftLength = longestPath(root.left)
        val rightLength = longestPath(root.right)
        if (root.left != null && root.`val` == root.left.`val` && root.right != null && root.`val` == root.right.`val`) {
            ans = max(ans, 2 + leftLength + rightLength)
        }

        if (root.left != null && root.`val` == root.left.`val`) {
            maxLength = leftLength + 1
        }
        if (root.right != null && root.`val` == root.right.`val`) {
            maxLength = max(rightLength + 1, maxLength)
        }
        ans = max(maxLength, ans)
        return maxLength
    }
}