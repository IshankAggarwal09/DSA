class Solution {
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int V = graph.length;
        ArrayList<ArrayList<Integer>> revAdj = new ArrayList<>();
        for (int i=0; i<V; i++) {
            revAdj.add(new ArrayList<Integer>());
        }
        for (int u=0; u<V; u++) {
            for (int v : graph[u]) {
                revAdj.get(v).add(u);
            }
        }
        int[] indegree = new int[graph.length];
        for (int i=0; i<graph.length; i++) {
            for (int it : revAdj.get(i)) {
                indegree[it]++;
            }
        }
        Queue<Integer> q = new LinkedList<>();
        List<Integer> safeNodes = new ArrayList<>();
        for (int i=0; i<V; i++) {
            if (indegree[i] == 0) {
                q.add(i);
            }
        }
        while (!q.isEmpty()) {
            int node = q.poll();
            safeNodes.add(node);
            for (int it : revAdj.get(node)) {
                indegree[it]--;
                if (indegree[it] == 0) {
                    q.add(it);
                }
            }
        }
        Collections.sort(safeNodes);
        return safeNodes;
    }
}