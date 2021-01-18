package LinkedList

import Utils.ListNode

/**
 * 剑指 Offer 24. 反转链表
 */
class ReverseList {
    fun reverseList(head: ListNode?): ListNode? {
        var pre:ListNode? = null
        var cur = head
        var next = cur?.next
        while (cur!=null) {
            cur.next = pre
            pre = cur
            cur = next
            next = next?.next
        }
        return pre
    }
}