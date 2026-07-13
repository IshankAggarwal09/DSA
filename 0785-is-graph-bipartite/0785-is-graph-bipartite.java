class Solution {
    public boolean check(int[][] graph, int[] color, int V, int start) {
        color[start] = 0;
        Queue<Integer> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            int node = q.poll();
            for (int it : graph[node]) {
                if (color[it] == -1) {
                    q.add(it);
                    color[it] = 1 - color[node];
                }
                else if (color[it] == color[node]) {
                    return false;
                }
            }
        }
        return true;
    }
    public boolean isBipartite(int[][] graph) {
        int[] color = new int[graph.length];
        for (int i=0; i<graph.length; i++) {
            color[i] = -1;
        }
        for (int i=0; i<graph.length; i++) {
            if (color[i] == -1) {
                if (!check(graph, color, graph.length, i)) {
                    return false;
                }
            }
        }
        return true;
    }
}