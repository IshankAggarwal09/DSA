class Pair {
    int first;
    int second;
    int third;
    Pair(int first, int second, int third) {
        this.first = first;
        this.second = second;
        this.third = third; 
    }
}

class Solution {
    public int[][] updateMatrix(int[][] mat) {
        int m = mat.length;
        int n = mat[0].length;
        int[][] vis = new int[m][n];
        int[][] dist = new int[m][n];
        Queue<Pair> q = new LinkedList<>();
        for (int i=0; i<m; i++) {
            for (int j=0; j<n; j++) {
                if (mat[i][j] == 0) {
                    q.add(new Pair(i, j, 0));
                    vis[i][j] = 1;
                }
            }
        }
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            int steps = q.peek().third;
            q.remove();
            dist[row][col] = steps;
            for (int k=0; k<4; k++) {
                int nRow = row + delRow[k];
                int nCol = col + delCol[k];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && vis[nRow][nCol] == 0) {
                    q.add(new Pair(nRow, nCol, steps+1));
                    vis[nRow][nCol] = 1;
                }
            }
        }
        return dist;
    }
}