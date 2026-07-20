class Pair {
    int u;
    int v;
    int weight;
    Pair(int u, int v, int weight) {
        this.u = u;
        this.v = v;
        this.weight = weight;
    }
}

class Solution {

    Queue<Pair> q = new PriorityQueue<>((a, b) -> a.weight - b.weight);
    int[][] dir = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    public boolean isSafe(int i, int j, int n, int m) {
        if (i >= 0 && i < n && j >= 0 && j < m) {
            return true;
        }
        return false;
    }

    public int shortestPathBinaryMatrix(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        int[][] res = new int[n][m];
        if (grid[n-1][m-1] == 1 || grid[0][0] == 1) {
            return -1;
        }
        for (int i=0; i<n; i++) {
            for (int j=0; j<m; j++) {
                res[i][j] = Integer.MAX_VALUE;
            }
        }
        res[0][0] = 1;
        q.add(new Pair(0, 0, 1));
        while (!q.isEmpty()) {
            int u = q.peek().u;
            int v = q.peek().v;
            int w = q.peek().weight;
            q.poll();
            for (int[] d : dir) {
                int x = u + d[0];
                int y = v + d[1];
                if (isSafe(x, y, n, m)) {
                    if (grid[x][y] == 0 && res[x][y] > 1 + res[u][v]) {
                        res[x][y] = 1 + res[u][v];
                        q.add(new Pair(x, y, res[x][y]));
                    }
                }
            }
        }
        return res[n-1][m-1] == Integer.MAX_VALUE ? -1 : res[n-1][m-1];
    }
}