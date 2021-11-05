package TreeNode

import Utils.ListNode

class DeleteNode {
    fun deleteNode(node: ListNode?) {
        node?.`val` = node?.next?.`val`
        node?.next = node?.next?.next
    }
}