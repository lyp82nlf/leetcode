import Utils.ListNode;

public class FirstCommonNode {
    //    1  2   3   4   5
//    2  2   5   4   5
    public static void main(String[] args) {
        FirstCommonNode firstCommonNode = new FirstCommonNode();
        ListNode pHead1 = firstCommonNode.generateListNode(new int[]{1, 3, 5, 6, 7}, 0);
        ListNode pHead2 = firstCommonNode.generateListNode(new int[]{4, 6, 7}, 0);
        ListNode listNode = firstCommonNode.FindFirstCommonNode(pHead1, pHead2);
        System.out.println(listNode.val);
    }


    public ListNode FindFirstCommonNode(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null || pHead2 == null) {
            return null;
        }
        if (pHead1.val == pHead2.val) {
            if (remainAllIsSame(pHead1.next, pHead2.next)) {
                return pHead1;
            }
        }
        ListNode listNode = FindFirstCommonNode(pHead1.next, pHead2);
        ListNode listNode1 = FindFirstCommonNode(pHead1, pHead2.next);
        ListNode listNode2 = FindFirstCommonNode(pHead1.next, pHead2.next);
        int i = nodeSize(listNode);
        int i1 = nodeSize(listNode1);
        int i2 = nodeSize(listNode2);
        return i > i1 ? i > i2 ? listNode : listNode2 : i1 > i2 ? listNode1 : listNode2;
    }

    public boolean remainAllIsSame(ListNode pHead1, ListNode pHead2) {
        if (pHead1 == null && pHead2 == null) {
            return true;
        }
        if (pHead1 == null || pHead2 == null) {
            return false;
        }
        if (pHead1.val != pHead2.val) {
            return false;
        } else {
            return remainAllIsSame(pHead1.next, pHead2.next);
        }
    }

    public int nodeSize(ListNode node) {
        if (node == null) {
            return 0;
        }
        int i = 1;
        while (node.next != null) {
            i++;
            node = node.next;
        }
        return i;
    }

    public static ListNode generateListNode(int[] s, int index) {
        if (index >= s.length) {
            return null;
        }
        ListNode listNode = new ListNode(s[index]);
        listNode.next = generateListNode(s, ++index);
        return listNode;
    }

}
