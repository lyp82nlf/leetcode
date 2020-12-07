package TreeNode

import Utils.TreeNode

fun generateTrees(n: Int): List<TreeNode?> {
    if (n == 0) {
        return ArrayList()
    }
    return generateTrees(1, n)
}

fun generateTrees(start: Int, end: Int): List<TreeNode?> {
    var allTrees = ArrayList<TreeNode?>()
    if (start > end) {
        allTrees.add(null)
        return allTrees
    }
    for (index in start..end) {
        var leftTrees = generateTrees(start, index - 1)
        var rightTrees = generateTrees(index + 1, end)
        for (left in leftTrees) {
            for (right in rightTrees) {
                val currTree = TreeNode(index);
                currTree.left = left;
                currTree.right = right;
                allTrees.add(currTree);
            }
        }
    }
    return allTrees
}


