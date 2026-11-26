/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
class Solution {
    public void markParent(TreeNode root, Map<TreeNode, TreeNode> parentTrack) {
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        while (!queue.isEmpty()) {
            TreeNode node = queue.poll();
            if (node.left != null) {
                parentTrack.put(node.left, node);
                queue.offer(node.left);
            }
            if (node.right != null) {
                parentTrack.put(node.right, node);
                queue.offer(node.right);
            }
        }
    }
    public List<Integer> distanceK(TreeNode root, TreeNode target, int k) {
        Map<TreeNode, TreeNode> parentTrack = new HashMap<>();
        markParent(root, parentTrack);
        Map<TreeNode, Boolean> visited = new HashMap<>();
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(target);
        int distance = 0;
        visited.put(target, true);
        while (!queue.isEmpty()) {
            int size = queue.size();
            if (distance == k) {
                break;
            }
            distance++;
            for (int i=0; i<size; i++) {
                TreeNode node = queue.poll();
                if (node.left != null && visited.get(node.left) == null) {
                    visited.put(node.left, true);
                    queue.offer(node.left);
                }
                if (node.right != null && visited.get(node.right) == null) {
                    visited.put(node.right, true);
                    queue.offer(node.right);
                }
                if (parentTrack.get(node) != null && visited.get(parentTrack.get(node)) == null) {
                    visited.put(parentTrack.get(node), true);
                    queue.offer(parentTrack.get(node));
                }
            }
        }
        List<Integer> ans = new ArrayList<>();
        while (!queue.isEmpty()) {
            ans.add(queue.poll().val);
        }
        return ans;
    }
}