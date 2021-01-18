package LinkedList

import Utils.ListNode

/**
 * 24. 两两交换链表中的节点
 */
class SwapPairs {

    fun swapPairs(head: ListNode?): ListNode? {
        if (head == null) {
            return null
        }
        val next = head.next
        if (next == null) {
            return head
        }
        head.next = next.next
        next.next = head
        head.next = swapPairs(head.next)
        return next
    }
}