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
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}
class Solution {
    public Pair solve(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        int option1 = left.first;
        int option2 = right.first;
        int option3 = left.second + right.second;
        int maxDiameter = Math.max(option1, Math.max(option2, option3));
        int maxHeight = Math.max(left.second, right.second) + 1;
        return new Pair(maxDiameter, maxHeight);

    }
    public int diameterOfBinaryTree(TreeNode root) {
        return solve(root).first;
    }
}