import Utils.ListNode;
import Utils.ListNodeUtil;

public class RemoveNthFromEnd {
    /*
     *
     * 给定一个链表，删除链表的倒数第 n 个节点，并且返回链表的头结点。
     * 示例：给定一个链表: 1->2->3->4->5, 和 n = 2.
     * 当删除了倒数第二个节点后，链表变为 1->2->3->5.
     * 你能尝试使用一趟扫描实现吗？
     *
     * */
    public static void main(String[] args) {
        ListNode head = ListNodeUtil.generateListNode(new int[]{1}, 0);
        ListNode listNode = new RemoveNthFromEnd().removeNthFromEnd(head, 1);
        ListNodeUtil.printListNode(listNode);
    }

    /**
     * Definition for singly-linked list.
     * public class Utils.ListNode {
     * int val;
     * Utils.ListNode next;
     * Utils.ListNode(int x) { val = x; }
     * }
     */
    /*
    * 思路1:暴力法,第一次扫描找到倒数第n个节点 第二次扫描得到前一个节点和后一个节点
    * 思路2:
    *   我们如果需要一次扫描就得到结果,那么只有两种方法,要么,记住所有的链表节点.那么自然可以删除想要删的任意节点,但是,浪费空间
    *   所以,我们可以引入一个类似滑动窗口的概念
    *   滑动窗口大小 == n
    *   所以当滑动窗口移动到最右边,滑动窗口最左边的值也就是我们需要删除的值
    * */
    public ListNode removeNthFromEnd(ListNode head, int n) {
        int size = 0;
        ListNode removeNode = head;
        ListNode preNode = head;
        ListNode currentNode = head;
        while (currentNode != null) {
            if (size == n) {
                preNode = removeNode;
                removeNode = removeNode.next;
            } else {
                size++;
//                n == 链表长度,删除头结点
                if (currentNode.next == null) {
                    head = head.next;
                    return head;
                }
            }
            currentNode = currentNode.next;
        }
        ListNode nextNode = removeNode.next;
        preNode.next = nextNode;
        removeNode.next = null;
        return head;
    }
}
