class Solution {
    public List<Integer> remainingMethods(int n, int k, int[][] invocations) {
        List<List<Integer>> directed = new ArrayList<>();
        List<List<Integer>> graph = new ArrayList<>();
        for (int i=0; i<n; i++) {
            directed.add(new ArrayList<>());
            graph.add(new ArrayList<>());
        }
        for (int[] e : invocations) {
            int u = e[0];
            int v = e[1];
            directed.get(u).add(v);
            graph.get(u).add(v);
            graph.get(v).add(u);
        }
        boolean[] suspicious = new boolean[n];
        boolean[] visited = new boolean[n];
        dfsSuspicious(k, directed, suspicious);
        for (int i=0; i<n; i++) {
            if (!suspicious[i] && !visited[i]) {
                dfsRestore(i, graph, suspicious, visited);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<n; i++) {
            if (!suspicious[i]) {
                ans.add(i);
            }
        }
        return ans;
    }
    private void dfsSuspicious(int node, List<List<Integer>> directed, boolean[] suspicious) {
        suspicious[node] = true;
        for (int next : directed.get(node)) {
            if (!suspicious[next]) {
                dfsSuspicious(next, directed, suspicious);
            }
        }
    }
    private void dfsRestore(int node, List<List<Integer>> graph, boolean[] suspicious, boolean[] visited) {
        visited[node] = true;
        for (int next : graph.get(node)) {
            if (!visited[next]) {
                suspicious[next] = false;
                dfsRestore(next, graph, suspicious, visited);
            }
        }
    }
}