class Solution {
    public int matrixScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        for (int i=0; i<m; i++) {
            if (grid[i][0] == 0) {
                for (int j=0; j<n; j++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        for (int j=0; j<n; j++) {
            int zeros = 0;
            int ones = 0;
            for (int i=0; i<m; i++) {
                if (grid[i][j] == 0) {
                    zeros++;
                }
                else {
                    ones++;
                }
            }
            if (zeros > ones) {
                for (int i=0; i<m; i++) {
                    grid[i][j] ^= 1;
                }
            }
        }
        int sum = 0;
        for (int i=0; i<m; i++) {
            int pow = 1;
            for (int j=n-1; j>=0; j--) {
                sum += grid[i][j] * pow;
                pow *= 2;
            }
        }
        return sum;
    }
}