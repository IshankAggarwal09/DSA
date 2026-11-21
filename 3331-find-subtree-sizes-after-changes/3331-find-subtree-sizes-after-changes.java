class Solution {
    private Map<Integer, Set<Integer>> adj;
    private String s;
    public int[] findSubtreeSizes(int[] parent, String s) {
        adj = new HashMap<>();
        this.s = s;
        for (int i=1; i<parent.length; i++) {
            adj.computeIfAbsent(parent[i], (v) -> new HashSet<>()).add(i);
        }
        dfs(0, new HashMap<>());
        for (int[] move : moves) {
            int from = move[0];
            int to = move[1];
            adj.get(parent[from]).remove(from);
            adj.get(to).add(from);
        }
        int[] res = new int[parent.length];
        size(0, res);
        return res;
    }
    public int size(int node, int[] res) {
        int total = 1;
        for (int nei : adj.get(node)) {
            total += size(nei, res);
        }
        return res[node] = total;
    }
    private List<int[]> moves = new ArrayList<>();
    public void dfs(int node, Map<Character, List<Integer>> seenNode) {
        char val = s.charAt(node);
        if (seenNode.containsKey(val)) {
            List<Integer> vals = seenNode.get(val); 
            moves.add(new int[]{node, vals.get(vals.size()-1)});
        }
        seenNode.computeIfAbsent(val, (v) -> new ArrayList<>()).add(node);
        for (int nei : adj.computeIfAbsent(node, (v) -> new HashSet<>())) {
            dfs(nei, seenNode);
        }
        seenNode.get(val).remove(seenNode.get(val).size()-1);
        if (seenNode.get(val).isEmpty()) {
            seenNode.remove(val);
        }
    }
}