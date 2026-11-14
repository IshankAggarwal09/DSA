class Solution {
    public int minimumSumSubarray(List<Integer> nums, int l, int r) {
        int n = nums.size();
        int[] pre = new int[n];
        int minSum = Integer.MAX_VALUE;
        pre[0] = nums.get(0);
        for (int i=1; i<n; i++) {
            pre[i] = pre[i - 1] + nums.get(i);
        }
        for (int win=l; win<=r; win++) {
            for (int j=win-1; j<n; j++) {
                int winSum = pre[j];
                if (j - win >= 0) {
                    winSum -= pre[j - win];
                }
                if (winSum > 0) {
                    minSum = Math.min(minSum, winSum);
                }
            }
        }
        return minSum == Integer.MAX_VALUE ? -1 : minSum;
    }
}