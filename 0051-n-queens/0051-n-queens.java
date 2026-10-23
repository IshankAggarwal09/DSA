class Solution {
    public boolean isSafe(int row, int col, List<String> temp, int n) {
        int r = row;
        int c = col;
        while (row >= 0 && col >= 0) {
            if (temp.get(row).charAt(col) == 'Q') {
                return false;
            }
            row--;
            col--;
        }
        row = r;
        col = c;
        while (col >= 0) {
            if (temp.get(row).charAt(col) == 'Q') {
                return false;
            }
            col--;
        }
        row = r;
        col = c;
        while (row < n && col >= 0) {
            if (temp.get(row).charAt(col) == 'Q') {
                return false;
            }
            row++;
            col--;
        }
        return true;
    }
    public void solve(int n, List<List<String>> ans, List<String> temp, int col) {
        if (col == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int row=0; row<n; row++) {
            if (isSafe(row, col, temp, n)) {
                char[] ch = temp.get(row).toCharArray();
                ch[col] = 'Q';
                temp.set(row, new String(ch));
                solve(n, ans, temp, col+1);
                ch[col] = '.';
                temp.set(row, new String(ch));
            }
        }
    }
    public List<List<String>> solveNQueens(int n) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        String s = ".".repeat(n);
        for (int i=0; i<n; i++) {
            temp.add(s);
        }
        solve(n, ans, temp, 0);
        return ans;
    }
}