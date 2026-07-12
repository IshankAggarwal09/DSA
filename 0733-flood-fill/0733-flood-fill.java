class Solution {
    public void dfs(int[][] image, int row, int col, int color, int original) {
        if (row < 0 || row >= image.length || col < 0 || col >= image[0].length || image[row][col] != original || image[row][col] == color) {
            return;
        }
        image[row][col] = color;
        dfs(image, row-1, col, color, original);
        dfs(image, row+1, col, color, original);
        dfs(image, row, col-1, color, original);
        dfs(image, row, col+1, color, original);
    }
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if (image[sr][sc] == color) {
            return image;
        }
        int original = image[sr][sc];
        dfs(image, sr, sc, color, original);
        return image;
    }
}