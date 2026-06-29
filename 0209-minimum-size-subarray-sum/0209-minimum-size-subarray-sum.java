class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLenWin = Integer.MAX_VALUE;
        int currentSum = 0;
        int low = 0;
        int high = 0;
        while (high < nums.length) {
            currentSum += nums[high];
            high++;
            while (currentSum >= target) {
                int currentWindowSize = high - low;
                minLenWin = Math.min(minLenWin, currentWindowSize);
                currentSum -= nums[low];
                low++;
            }
        }
        return minLenWin == Integer.MAX_VALUE ? 0 : minLenWin;
    }
}