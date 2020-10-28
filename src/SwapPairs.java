import Utils.ListNode;
import Utils.ListNodeUtil;

public class SwapPairs {
    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.generateListNode(new int[]{1, 2, 3, 4, 5, 6}, 0);
        ListNode listNode1 = new SwapPairs().swapPairs(listNode);
        ListNodeUtil.printListNode(listNode1);
    }

    /*
    * 给定一个链表，两两交换其中相邻的节点，并返回交换后的链表。
    你不能只是单纯的改变节点内部的值，而是需要实际的进行节点交换。
    示例:
    给定 1->2->3->4, 你应该返回 2->1->4->3.
    * */
    public ListNode swapPairs(ListNode head) {
        //思路 A -> B -> C
        // 如果 B存在 否则返回A
        // 1.A -> C  B ->A 递归C
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return head;
        }
        ListNode nextNode = head.next;
        head.next = swapPairs(nextNode.next);
        nextNode.next = head;
        return nextNode;
    }
}
