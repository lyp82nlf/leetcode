import Utils.TreeNode;

public class ReconstructTheBinaryTree {
    /*
     * 题目描述
     * 输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
     * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
     * */
    public static void main(String[] args) {
        int[] pre = {1, 2, 4, 7, 3, 5, 6, 8};
        int[] in = {4, 7, 2, 1, 5, 3, 8, 6};
        reConstructBinaryTree(pre, in);
    }

    /*
     * 思路:
     *   先序第一个就是根节点
     *   中序第一个就是最左节点
     *   然后假设在pre数组中 最左节点的位置 i  在中序数组中根节点为j
     *   那么  中序  0 - j 为左边节点   j+1 到length 为右节点
     *        先序  0 - i 为左节点     i+1 到length 为由节点
     *   然后使用递归就完成了重构二叉树
     * */
    public static TreeNode reConstructBinaryTree(int[] pre, int[] in) {
        TreeNode treeNode = reConstructBinaryTreeWithRecursive(pre, 0, pre.length - 1, in, 0, in.length - 1);
        preOrderTraversalWithRecursive(treeNode);
        return treeNode;
    }

    public static TreeNode reConstructBinaryTreeWithRecursive(int[] pre, int startPre, int endPre, int[] in, int startIn, int endIn) {
        if (startPre > endPre) {
            return null;
        }
        int firstNodeValue = pre[startPre];
        TreeNode firstNode = new TreeNode(firstNodeValue);
        for (int i = startIn; i <= endIn; i++) {
            if (in[i] == firstNodeValue) {
                firstNode.left = reConstructBinaryTreeWithRecursive(pre, startPre + 1, startPre + i - startIn, in, startIn, i - 1);
                firstNode.right = reConstructBinaryTreeWithRecursive(pre, i - startIn + startPre + 1, endPre, in, i + 1, endIn);
                break;
            }
        }
        return firstNode;
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


}
