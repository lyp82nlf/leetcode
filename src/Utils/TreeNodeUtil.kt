package Utils

import java.util.*


/*/

 3
/ \
9  20
/  \
15   7

*/
fun generateTreeNodeList(): TreeNode {
    var result: TreeNode = TreeNode(3)
    var result1: TreeNode = TreeNode(9)
    var result2: TreeNode = TreeNode(20)
    var result3: TreeNode = TreeNode(15)
    var result4: TreeNode = TreeNode(7)
    result.left = result1
    result.right = result2
    result2.left = result3
    result2.right = result4
    return result
}

//数组构成TreeNode 不可为null
//        [0,0,null,0,null,0,null,null,0]
fun generateTreeNodeList(array: Array<Int?>): TreeNode? {
    if (array.isEmpty()) {
        return null
    }
    var queue = LinkedList<TreeNode>()
    var root = TreeNode(array[0]!!)
    queue.offer(root)
    var left = true
    for (index in 1 until array.size) {
        var node = queue.peek()
        if (left) {
            if (array[index] != null) {
                node.left = TreeNode(array[index]!!)
                queue.offer(node.left)
            }
            left = false
        } else {
            if (array[index] != null) {
                node.right = TreeNode(array[index]!!)
                queue.offer(node.left)
            }
            queue.poll()
            left = true
        }
    }
    return root
}
