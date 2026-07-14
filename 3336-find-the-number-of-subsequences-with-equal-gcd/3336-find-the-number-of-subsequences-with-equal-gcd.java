class Solution {
    int MOD = 1000000007;
    public int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
    public int subsequencePairCount(int[] nums) {
        int n = nums.length;
        int maxEl = nums[0];
        for (int num : nums) {
            maxEl = Math.max(maxEl, num);
        }
        int[][][] t = new int[n+1][maxEl+1][maxEl+1];
        for (int first=0; first<=maxEl; first++) {
            for (int second=0; second<=maxEl; second++) {
                boolean bothNonEmpty = (first != 0 && second != 0);
                boolean gcdsMatch = (first == second);
                t[n][first][second] = (bothNonEmpty && gcdsMatch) ? 1 : 0;
            }
        }
        for (int i=n-1; i>=0; i--) {
            for (int first=maxEl; first>=0; first--) {
                for (int second=maxEl; second>=0; second--) {
                    int skip = t[i+1][first][second];
                    int take1 = t[i+1][gcd(first, nums[i])][second];
                    int take2 = t[i+1][first][gcd(second, nums[i])];
                    t[i][first][second] = (int)(((long)skip + take1 + take2) % MOD);
                }
            }
        }
        return t[0][0][0];
    }
}