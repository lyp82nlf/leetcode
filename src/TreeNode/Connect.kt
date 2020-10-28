package TreeNode

import java.util.*

class Connect {
    fun connect(root: Node?): Node? {
        var prev = root
        var root = root
        val stack = Stack<Node>()
        stack.push(root)
        while (!stack.isEmpty() || root != null) {
            root = stack.pop()
            prev!!.next = root
            stack.push(root.left)
            stack.push(root.right)
            prev = root
        }
        return root
    }
}