class Solution {
    public void setCell(List<String> board, int row, int col, char c) {
        char[] ch = board.get(row).toCharArray();
        ch[col] = c;
        board.set(row, new String(ch));
    }
    public void solve(List<List<String>> ans, List<String> board, int n, int col, int[] leftRow, int[] upperDiagonal, int[] lowerDiagonal) {
        if (col == n) {
            ans.add(new ArrayList<>(board));
            return;
        }
        for (int row=0; row<n; row++) {
            if (leftRow[row] == 0 && lowerDiagonal[row+col] == 0 && upperDiagonal[n-1+col-row] == 0) {
                setCell(board, row, col, 'Q');
                leftRow[row] = 1;
                lowerDiagonal[row + col] = 1;
                upperDiagonal[n-1 + col - row] = 1;
                solve(ans, board, n, col+1, leftRow, upperDiagonal, lowerDiagonal);
                setCell(board, row, col, '.');
                leftRow[row] = 0;
                lowerDiagonal[row + col] = 0;
                upperDiagonal[n-1 + col - row] = 0;
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> board = new ArrayList<>();
        String s = ".".repeat(n);
        for (int i=0; i<n; i++) {
            board.add(s);
        }
        int[] leftRow = new int[n];
        int[] upperDiagonal = new int[2*n-1];
        int[] lowerDiagonal = new int[2*n-1];
        solve(ans, board, n, 0, leftRow, upperDiagonal, lowerDiagonal);
        return ans;
    }
}