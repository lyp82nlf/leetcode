package listNode

import Utils.ListNode

class GetKthFromEnd {
    fun getKthFromEnd(head: ListNode?, k: Int): ListNode? {
        if (head == null) {
            return null
        }
        var k = k
        var l = head
        var r = head
        while (r!!.next != null) {
            if (k > 1) {
                k--
            } else {
                l = l!!.next
            }
            r = r.next
        }
        return l
    }
}