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
class Tuple {
    TreeNode node;
    int verticalIndex;
    int level;
    Tuple(TreeNode node, int verticalIndex, int level) {
        this.node = node;
        this.verticalIndex = verticalIndex;
        this.level = level;
    }
}
class Solution {
    public List<List<Integer>> verticalTraversal(TreeNode root) {
        List<List<Integer>> ans = new ArrayList<>();
        if (root == null) {
            return ans;
        }
        Queue<Tuple> queue = new LinkedList<>();
        queue.offer(new Tuple(root, 0, 0));
        TreeMap<Integer, TreeMap<Integer, PriorityQueue<Integer>>> map = new TreeMap<>();
        while (!queue.isEmpty()) {
            Tuple tuple = queue.poll();
            TreeNode node = tuple.node;
            int verticalIndex = tuple.verticalIndex;
            int level = tuple.level;
            if (!map.containsKey(verticalIndex)) {
                map.put(verticalIndex, new TreeMap<>());
            }
            if (!map.get(verticalIndex).containsKey(level)) {
                map.get(verticalIndex).put(level, new PriorityQueue<>());
            }
            map.get(verticalIndex).get(level).offer(node.val);
            if (node.left != null) {
                queue.offer(new Tuple(node.left, verticalIndex-1, level+1));
            }
            if (node.right != null) {
                queue.offer(new Tuple(node.right, verticalIndex+1, level+1));
            }
        }
        for (TreeMap<Integer, PriorityQueue<Integer>> ys : map.values()) {
            ans.add(new ArrayList<>());
            for (PriorityQueue<Integer> nodes : ys.values()) {
                while (!nodes.isEmpty()) {
                    ans.get(ans.size()-1).add(nodes.poll());
                }
            }
        }
        return ans;
    }
}