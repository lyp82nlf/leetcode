package Utils;

import java.util.LinkedList;
import java.util.Queue;

public class ListNodeUtil {
    public static ListNode generateListNode(int[] s, int index) {
        if (index >= s.length) {
            return null;
        }
        ListNode listNode = new ListNode(s[index]);
        listNode.next = generateListNode(s, ++index);
        return listNode;
    }


    //按照层级的方式恢复成二叉树
    public static TreeNode arrayToTree(Integer[] arr) {
        if (arr == null || arr.length == 0) {
            return null;
        }

        int index = 0;
        TreeNode root = new TreeNode(arr[index++]);
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        while (!queue.isEmpty() && index < arr.length) {
            TreeNode node = queue.poll();
            Integer leftValue = arr[index++];
            if (leftValue != null) {
                node.left = new TreeNode(leftValue);
                queue.offer(node.left);
            }

            if (index < arr.length) {
                Integer rightValue = arr[index++];
                if (rightValue != null) {
                    node.right = new TreeNode(rightValue);
                    queue.offer(node.right);
                }
            }
        }

        return root;
    }

    public static void printListNode(ListNode head) {
        while (head != null) {
            System.out.print(head.val +" -> ");
            head = head.next;
        }
    }
}
