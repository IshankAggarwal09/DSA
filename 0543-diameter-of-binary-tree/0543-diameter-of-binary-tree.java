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
    int first; // Diameter
    int second; // Height
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
} 
class Solution {
    public Pair diameter(TreeNode root) {
        if (root == null) {
            return new Pair(0, 0);
        }
        Pair left = diameter(root.left); 
        Pair right = diameter(root.right);
        int option1 = left.first; // Diameter of left subtree
        int option2 = right.first; // Diameter of right subtree
        int option3 = left.second + right.second; // Diameter (edge count) of the longest path passing through the current node
        int maxDiameter = Math.max(option1, Math.max(option2, option3)); // Max Diameter from all options 
        int height = Math.max(left.second, right.second) + 1; // Maximum height of subtree rooted at current node
        return new Pair(maxDiameter, height); // Stored as {Max Diameter, Max height}
    }
    public int diameterOfBinaryTree(TreeNode root) {
        return diameter(root).first;
    }
}