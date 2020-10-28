import Utils.ListNode

class HasCycle {
    fun hasCycle(head: ListNode?): Boolean {
        if (head == null || head.next == null) {
            return false
        }
        var fast = head.next
        var slow = head
        while (fast != slow) {
            if (fast == null || fast.next == null) {
                return false
            }
            fast = fast.next.next
            slow = slow!!.next
        }
        return true
    }
}