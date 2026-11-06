class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLenWin = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int n = nums.length;
        int sum = 0;
        while (right < n) {
            sum += nums[right];
            while (sum >= target) {
                minLenWin = Math.min(minLenWin, right - left + 1);
                sum -= nums[left];
                left++;
            }
            right++;
        }
        return minLenWin == Integer.MAX_VALUE ? 0 : minLenWin;
    }
}