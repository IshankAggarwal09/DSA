class Solution {
    public boolean dfs(int node, int[] vis, int[] pathVis, int[] check, int[][] graph) {
        vis[node] = 1;
        pathVis[node] = 1;
        check[node] = 0;
        for (int it : graph[node]) {
            if (vis[it] == 0) {
                if (dfs(it, vis, pathVis, check, graph)) {
                    return true;
                }
            }
            else if (pathVis[it] == 1) {
                return true;
            }
        }
        check[node] = 1;
        pathVis[node] = 0;
        return false;
    }
    public List<Integer> eventualSafeNodes(int[][] graph) {
        int[] vis = new int[graph.length];
        int[] pathVis = new int[graph.length];
        int[] check = new int[graph.length];
        for (int i=0; i<graph.length; i++) {
            if (vis[i] == 0) {
                dfs(i, vis, pathVis, check, graph);
            }
        }
        List<Integer> ans = new ArrayList<>();
        for (int i=0; i<graph.length; i++) {
            if (check[i] == 1) {
                ans.add(i);
            }
        }
        return ans;
    }
}