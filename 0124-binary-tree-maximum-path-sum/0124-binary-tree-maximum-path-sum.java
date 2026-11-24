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
            return new Pair(0, Integer.MIN_VALUE);
        }
        Pair left = solve(root.left);
        Pair right = solve(root.right);
        int leftGain = Math.max(0, left.first);
        int rightGain = Math.max(0, right.first);
        int throughRoot = root.val + leftGain + rightGain;
        int maxDown = Math.max(leftGain, rightGain) + root.val;
        int maxPath = Math.max(throughRoot, Math.max(left.second, right.second));
        return new Pair(maxDown, maxPath);
    }
    public int maxPathSum(TreeNode root) {
        return solve(root).second;
    }
}