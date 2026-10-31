class Solution {
    public int uniquePaths(int[][] grid) {
        int r = grid.length, c = grid[0].length, MOD = (int)1e9+7;
        int[][] left = new int[r][c];
        int[][] up = new int[r][c];
        left[0][0] = 1;
        for(int i=0; i<r; i++) {
            for(int j=0; j<c; j++) {
                if(grid[i][j] == 1) {
                    if(i > 0) { 
                        up[i][j] = (up[i][j] + left[i - 1][j]) % MOD;
                    }
                    if(j > 0) {
                        left[i][j] = (left[i][j] + (grid[i][j - 1] == 1 ? up[i][j - 1] : left[i][j - 1])) % MOD;
                    }
                }
                else {
                    if(i > 0) {
                        left[i][j] = (left[i][j] +  left[i - 1][j]) % MOD;
                    }
                    if(j > 0) {
                        left[i][j] = (left[i][j] + (grid[i][j - 1] == 1 ? up[i][j - 1] : left[i][j - 1])) % MOD;
                    }
                }
            }
        }
        return (left[r - 1][c - 1] + up[r - 1][c - 1]) % MOD;
    }
}