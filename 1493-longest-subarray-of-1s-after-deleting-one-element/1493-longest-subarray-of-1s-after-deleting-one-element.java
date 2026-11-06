class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int lastZeroIndex = -1;
        int answer = 0;
        int left = 0;
        for (int right=0; right<n; right++) {
            if (nums[right] == 0) {
                left = lastZeroIndex + 1;
                lastZeroIndex = right;
            }
            answer = Math.max(answer, right - left);
        }
        return answer;
    }
}