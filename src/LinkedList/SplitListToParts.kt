package LinkedList

import Utils.ListNode

class SplitListToParts {
    fun splitListToParts(head: ListNode?, k: Int): Array<ListNode?> {
        var count = 0
        var p = head
        while (p != null) {//计算链表长度
            p = p.next
            count++
        }

        val s = count / k//每组 s 个元素
        var c = count % k//不能整除时, 余下的结点个数
        val ans = Array<ListNode?>(k) { null }
        p = head
        for (i in 0 until k) {//k 组
            ans[i] = p
            var left = s
            var pre = p
            while (left-- > 0) {//每组分配的结点
                pre = p
                p = p?.next
            }
            if (c > 0) {//余下的结点个数, 分配到前 c 个元素
                pre = p
                p = p?.next
                c--
            }
            pre?.next = null//将该组最后一个结点的引用去掉.
        }
        return ans
    }
}