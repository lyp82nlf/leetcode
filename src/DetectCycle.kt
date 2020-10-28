import Utils.ListNode

class DetectCycle {
    fun detectCycle(head: ListNode?): ListNode? {
        if (head == null || head.next == null) {
            return null
        }
        var fast = head
        var slow = head
        while (fast != null) {
            if (fast.next != null) {
                fast = fast.next.next
            } else {
                return null
            }
            slow = slow!!.next
            if (slow == fast) {
                var ptr = head
                while (slow != ptr) {
                    slow = slow!!.next
                    ptr = ptr!!.next
                }
                return ptr
            }
        }
        return null
    }
}