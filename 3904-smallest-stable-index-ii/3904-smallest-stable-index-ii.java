class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        int[] dp = new int[n];
        int mint = Integer.MAX_VALUE;
        for (int i=n-1; i>=0; i--) {
            if (nums[i] < mint) {
                mint = nums[i];
            }
            dp[i] = mint;
        }
        int maxt = 0;
        for (int i=0; i<n; i++) {
            if (nums[i] > maxt) {
                maxt = nums[i];
            }
            if (maxt - dp[i] <= k) {
                return i;
            }
        }
        return -1;
    }
}