package LinkedList

import Utils.ListNode

/**
 * 25. K 个一组翻转链表
 */
class ReverseKGroup {
    fun reverseKGroup(head: ListNode?, k: Int): ListNode? {
        var pre: ListNode? = null
        var cur = head
        var next = cur?.next
        var tmpK = k
        val canArriveK = canArriveK(head, k)
        if (canArriveK) {
            while (cur != null && tmpK > 0) {
                cur.next = pre
                pre = cur
                cur = next
                next = next?.next
                tmpK--
            }
        } else {
            return head
        }
        head?.next = reverseKGroup(cur, k)
        return pre
    }

    fun canArriveK(head: ListNode?, k: Int): Boolean {
        var head = head
        var k = k
        while (k > 1) {
            head = head?.next
            k--
        }
        return head != null
    }


}