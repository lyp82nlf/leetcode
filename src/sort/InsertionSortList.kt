package sort

import Utils.ListNode
import Utils.ListNodeUtil

class InsertionSortList {
    fun insertionSortList(head: ListNode?): ListNode? {
        val dummyHead = ListNode(0)
        dummyHead.next = head
        var root = head
        while (root != null) {
            var next = root.next
            if (next != null && next.`val` < root.`val`) {
                var prev: ListNode? = dummyHead
                while (prev != null) {
                    if (prev.next != null && next.`val` < prev.next.`val`) {
                        root.next = next.next
                        next.next = prev.next
                        prev.next = next
                        prev = null
                    } else {
                        prev = prev.next
                    }
                }
            }
            root = next
        }
        return dummyHead.next
    }
}

fun main() {
    InsertionSortList().insertionSortList(ListNodeUtil.generateListNode(intArrayOf(4, 2, 1, 3), 0))
}