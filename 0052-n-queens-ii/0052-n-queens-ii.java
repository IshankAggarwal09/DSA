class Solution {
    private boolean isSafePlace(int n, char[][] nQueens, int row, int col) {
        for (int i = 0; i < n; i++) {
            if (nQueens[i][col] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col - 1; i >= 0 && j >= 0; i--, j--) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }
        for (int i = row - 1, j = col + 1; i >= 0 && j < n; i--, j++) {
            if (nQueens[i][j] == 'Q') {
                return false;
            }
        }
        return true;
    }
    private void solveNQueens(int n, int[] count, char[][] nQueens, int row) {
        if (row == n) {
            count[0]++;
            return;
        }
        for (int col = 0; col < n; col++) {
            if (isSafePlace(n, nQueens, row, col)) {
                nQueens[row][col] = 'Q';
                solveNQueens(n, count, nQueens, row + 1);
                nQueens[row][col] = '.';
            }
        }
    }
    public int totalNQueens(int n) {
        int[] count = new int[1];  
        char[][] nQueens = new char[n][n];  
        for (int i = 0; i < n; i++) {
            Arrays.fill(nQueens[i], '.');
        }
        solveNQueens(n, count, nQueens, 0); 
        return count[0];
    }
}