/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Pair {
    boolean balanced;
    int height;
    Pair (boolean balanced, int height) {
        this.balanced = balanced;
        this.height = height;
    }
}
class Solution {
    public Pair check(TreeNode root) {
        if (root == null) {
            return new Pair(true, 0);
        }
        Pair left = check(root.left);
        Pair right = check(root.right);
        boolean option1 = left.balanced;
        boolean option2 = right.balanced;
        boolean option3 = Math.abs(left.height - right.height) <= 1;
        int maxHeight = Math.max(left.height, right.height) + 1;
        if (option1 && option2 && option3) {
            return new Pair(true, maxHeight);
        }
        return new Pair(false, maxHeight);
    }
    public boolean isBalanced(TreeNode root) {
        return check(root).balanced;
    }
}