package LinkedList

import Utils.ListNode

/**
 * 25. K 个一组翻转链表
 */
class ReverseKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var remainK = k
        var current = head
        var next = current?.next
        if (current == null || next == null) {
            return head
        }
        while (remainK > 0) {
            var node =  next.next
            next.next = current

        }
        head.next = reverseKGroup(next.next,k)
    }
}