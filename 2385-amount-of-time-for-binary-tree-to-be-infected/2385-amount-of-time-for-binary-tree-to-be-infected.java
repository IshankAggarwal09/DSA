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
class Solution {
    public TreeNode markParent(TreeNode root, Map<TreeNode, TreeNode> parentTrack, int start) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        TreeNode temp = null;
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.val == start) {
                temp = node;
            }
            if (node.left != null) {
                parentTrack.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentTrack.put(node.right, node);
                queue.offer(node.right);
            }
        }
        return temp;
    }
    public int amountOfTime(TreeNode root, int start) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        TreeNode target = markParent(root, parentTrack, start);
        Queue<TreeNode> queue = new LinkedList<>();
        Map<TreeNode, Boolean> visited = new HashMap<>();
        queue.offer(target);
        visited.put(target, true);
        int time = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            boolean infected = false;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    queue.offer(node.left);
                    visited.put(node.left, true);
                    infected = true;
                }
                if (node.right != null && visited.get(node.right) == null) {
                    queue.offer(node.right);
                    visited.put(node.right, true);
                    infected = true;
                }
                if (parentTrack.get(node) != null && visited.get(parentTrack.get(node)) == null) {
                    queue.offer(parentTrack.get(node));
                    visited.put(parentTrack.get(node), true);
                    infected = true;
                }
            }
            if (infected) {
                time++;
            }
        }
        return time;
    }
}