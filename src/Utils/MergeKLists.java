package Utils;

import java.util.Arrays;

public class MergeKLists {

    public static void main(String[] args) {
        ListNode listNode = ListNodeUtil.generateListNode(new int[]{1, 3, 5, 7, 9}, 0);
        ListNode listNode1 = ListNodeUtil.generateListNode(new int[]{2, 4, 6, 8, 10}, 0);
        ListNode listNode2 = new MergeKLists().mergeKLists(new ListNode[]{listNode, listNode1});

        ListNodeUtil.printListNode(listNode2);
    }


    public ListNode mergeKLists(ListNode[] lists) {
        if (lists.length == 0) {
            return null;
        }
        if (lists.length == 1) {
            return lists[0];
        }
        ListNode[] result;
        int j = 0;
        if (lists.length % 2 != 0) {
            result = new ListNode[lists.length / 2 + 1];
            result[j] = lists[lists.length - 1];
            j++;
        } else {
            result = new ListNode[lists.length / 2];
        }
        for (int i = 0; i < lists.length / 2; i += 1) {
            ListNode listNode = mergeTwoLists(lists[i * 2], lists[i * 2 + 1]);
            result[j] = listNode;
            j++;
        }
        return mergeKLists(result);
    }


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
