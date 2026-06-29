class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int minLenWin = Integer.MAX_VALUE;
        int left = 0;
        int right = 0;
        int currSum = 0;
        while (right < nums.length) {
            currSum += nums[right];
            right++;
            while (currSum >= target) {
                minLenWin = Math.min(minLenWin, right-left);
                currSum -= nums[left];
                left++;
            }
        }
        return minLenWin == Integer.MAX_VALUE ? 0 : minLenWin;
    }
}