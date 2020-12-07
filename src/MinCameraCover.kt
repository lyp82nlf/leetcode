import Utils.TreeNode
import TreeNode.generateTreeNodeList

class MinCameraCover {
    var sum = 0
    fun minCameraCover(root: TreeNode?): Int {
        if (root == null) {
            return 0
        }
        val left = root.left
        val right = root.right
        sum += 1
        if (left == null) {
            right?.let {
                var leftChild = it.left
                var rightChild = it.right
                leftChild?.let { it ->
                    minCameraCover(it.left)
                    minCameraCover(it.right)
                }
                rightChild?.let { it ->
                    minCameraCover(it.left)
                    minCameraCover(it.right)
                }
            }
        } else {
            left.let {
                val leftChild = it.left
                val rightChild = it.right
                leftChild?.let { it ->
                    minCameraCover(it.left)
                    minCameraCover(it.right)
                }
                rightChild?.let { it ->
                    minCameraCover(it.left)
                    minCameraCover(it.right)
                }
            }
            minCameraCover(right)
        }
        return sum
    }
}

fun main() {
    var root = generateTreeNodeList(arrayOf(0, 0, 0))
    println(MinCameraCover().minCameraCover(root))
}