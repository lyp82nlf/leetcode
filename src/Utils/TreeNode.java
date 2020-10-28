package Utils;

public class TreeNode {
    public int val;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int x) {
        val = x;
    }


    public static void preOrderTraversalWithRecursive(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.print(treeNode.val + " --- ");
        preOrderTraversalWithRecursive(treeNode.left);
        preOrderTraversalWithRecursive(treeNode.right);
    }
}
