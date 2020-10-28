package Utils;

public class ListNodeUtil {
    public static ListNode generateListNode(int[] s, int index) {
        if (index >= s.length) {
            return null;
        }
        ListNode listNode = new ListNode(s[index]);
        listNode.next = generateListNode(s, ++index);
        return listNode;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val +" -> ");
            head = head.next;
        }
    }
}
