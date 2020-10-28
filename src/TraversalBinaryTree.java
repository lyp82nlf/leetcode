import Utils.TreeNode;

import java.util.Stack;

public class TraversalBinaryTree {
    /*
     * 遍历二叉树, 先序 中序  后序   递归 非递归
     * */

    public static void main(String[] args) {
        /*
         *                   构造一颗树
         *                       1
         *                      / \
         *                     2   3
         *                    / \   \
         *                   4   5   6
         *                  / \     / \
         *                 7  10   8   9
         * */
        TreeNode treeNode1 = new TreeNode(1);
        TreeNode treeNode2 = new TreeNode(2);
        TreeNode treeNode3 = new TreeNode(3);
        TreeNode treeNode4 = new TreeNode(4);
        TreeNode treeNode5 = new TreeNode(5);
        TreeNode treeNode6 = new TreeNode(6);
        TreeNode treeNode7 = new TreeNode(7);
        TreeNode treeNode8 = new TreeNode(8);
        TreeNode treeNode9 = new TreeNode(9);
        TreeNode treeNode10 = new TreeNode(10);

        treeNode1.left = treeNode2;
        treeNode1.right = treeNode3;
        treeNode2.left = treeNode4;
        treeNode2.right = treeNode5;
        treeNode3.right = treeNode6;
        treeNode4.left = treeNode7;
        treeNode4.right = treeNode10;

        treeNode6.left = treeNode8;
        treeNode6.right = treeNode9;
        PostOrderTraversalWithRecursive(treeNode1);
    }


    /*
     * 先序递归方法 顺序 中 左 右
     * */
    public static void preOrderTraversalWithRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " --- ");
        preOrderTraversalWithRecursive(treeNode.left);
        preOrderTraversalWithRecursive(treeNode.right);
    }


    /*
     * 先序非递归方法  顺序 中 左 右
     * */
    public static void preOrderTraversalWithNoRecursive(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        while (treeNode != null || !stack.empty()) {
            while (treeNode != null) {
                System.out.print(treeNode.val + "  ");
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                treeNode = treeNode.right;
            }
        }
    }

    /*
     * 中序遍历递归   顺序:  左  中  右
     * */
    public static void midOrderTraversalWithRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        midOrderTraversalWithRecursive(treeNode.left);
        System.out.print(treeNode.val + " ");
        midOrderTraversalWithRecursive(treeNode.right);
    }

    /*
     * 中序遍历,非递归方法   顺序:  左  中  右
     * */
    public static void midOrderTraversalWithNoRecursive(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack();
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }

            if (!stack.isEmpty()) {
                treeNode = stack.pop();
                System.out.printf(treeNode.val + " ");
                treeNode = treeNode.right;
            }
        }
    }

    /*
     * 后序遍历 递归
     * 顺序  左 右 中
     * */
    public static void PostOrderTraversalWithRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        PostOrderTraversalWithRecursive(treeNode.left);
        PostOrderTraversalWithRecursive(treeNode.right);
        System.out.printf(treeNode.val + " ");
    }


    /*
     * 后序遍历 非递归
     * 顺序  左 右 中
     * 思路: 后序遍历和前面的还不太一样,需要确定左右子树都已经遍历完成,才可以输出根子树
     * */
    public static void PostOrderTraversalWithNoRecursive(TreeNode treeNode) {
        Stack<TreeNode> stack = new Stack<>();
        TreeNode lastTreeNode = treeNode;
        while (treeNode != null || !stack.isEmpty()) {
            while (treeNode != null) {
                stack.push(treeNode);
                treeNode = treeNode.left;
            }
            treeNode = stack.peek();
            if (treeNode.right == null || treeNode.right == lastTreeNode) {
                System.out.print(treeNode.val + " ");
                lastTreeNode = stack.pop();
            } else {
                treeNode = treeNode.right;
            }
        }
    }


}
