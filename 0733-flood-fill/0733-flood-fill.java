class Pair {
    int first;
    int second;
    Pair(int first, int second) {
        this.first = first;
        this.second = second;
    }
}

class Solution {
    public void bfs(int[][] image, int sr, int sc, int color, boolean[][] vis) {
        vis[sr][sc] = true;
        Queue<Pair> q = new LinkedList<>();
        q.add(new Pair(sr, sc));
        int m = image.length;
        int n = image[0].length;
        int[] delRow = {-1, 0, 1, 0};
        int[] delCol = {0, 1, 0, -1};
        int ogColor = image[sr][sc];
        image[sr][sc] = color;
        while (!q.isEmpty()) {
            int row = q.peek().first;
            int col = q.peek().second;
            q.remove();
            for (int k=0; k<4; k++) {
                int nRow = row + delRow[k];
                int nCol = col + delCol[k];
                if (nRow >= 0 && nRow < m && nCol >= 0 && nCol < n && image[nRow][nCol] == ogColor && vis[nRow][nCol] == false) {
                    vis[nRow][nCol] = true;
                    image[nRow][nCol] = color;
                    q.add(new Pair(nRow, nCol));
                }
            }
        }
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int m = image.length;
        int n = image[0].length;
        boolean[][] vis = new boolean[m][n];
        bfs(image, sr, sc, color, vis);
        return image;
    }
}