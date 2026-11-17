class Solution {
    public int minimumChanges(String s, int k) {
        int n = s.length();
        int[][] a = new int[n][n];
        for (int[] row : a) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        for (int i=0; i<n; i++) {
            for (int j=i+1; j<n; j++) {
                int len = j - i + 1;
                for (int d=1; d<len; d++) {
                    if (len % d != 0) {
                        continue;
                    }
                    int m = len / d;
                    int y = 0;
                    for (int r=0; r<d; r++) {
                        for (int t=0; t<m/2; t++) {
                            if (s.charAt(i + r + t * d) != s.charAt(i + r + (m - 1 - t) * d)) {
                                y++;
                            }
                        }
                    }
                    a[i][j] = Math.min(a[i][j], y);
                }
            }
        }
        int[][] dp = new int[n + 1][k + 1];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        dp[0][0] = 0;
        for (int j=2; j<=n; j++) {
            for (int  p=1; p<=k; p++) {
                for (int i=0; i+2<=j; i++) {
                    if (dp[i][p - 1] == Integer.MAX_VALUE) {
                        continue;
                    }
                    dp[j][p] = Math.min(dp[j][p], dp[i][p - 1] + a[i][j - 1]);
                }
            }
        }
        return dp[n][k];
    }
}