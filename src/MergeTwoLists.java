import Utils.ListNode;
import Utils.ListNodeUtil;

public class MergeTwoLists {
    /*
     * 将两个有序链表合并为一个新的有序链表并返回。新链表是通过拼接给定的两个链表的所有节点组成的。 
     * 示例：
     * 输入：1->2->4, 1->3->4
     * 输出：1->1->2->3->4->4
     * */
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.generateListNode(new int[]{1, 2, 4}, 0);
        ListNode listNode1 = ListNodeUtil.generateListNode(new int[]{1, 3, 4}, 0);
        ListNode res = new MergeTwoLists().mergeTwoLists(listNode, listNode1);
        ListNodeUtil.printListNode(res);
    }

   /*
     * 虽然这道题的困难度是简单,但是很有意思,看一下怎么解决.
     * 看到的第一眼就是两个指针滑动解决.后来发现这实在是暴力法,要记录很多变量,没意思.
     * 又想了一下正向流程,首先,要记住,这是一个链表.第一步合并
     * 1->1->3->4  2->4
     * 然后将1->3->4  和 2->4 合并
     * ?????
     * 递归的感觉出来没
     * */
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if (l1 == null) {
            return l2;
        }
        if (l2 == null) {
            return l1;
        }
        if (l1.val <= l2.val) {
            ListNode next = l1.next;
            l1.next = mergeTwoLists(next, l2);
            return l1;
        } else {
            ListNode next = l2.next;
            l2.next = mergeTwoLists(next, l1);
            return l2;
        }
    }
}
