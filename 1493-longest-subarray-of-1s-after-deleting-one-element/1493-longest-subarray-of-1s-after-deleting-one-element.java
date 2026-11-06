class Solution {
    public int longestSubarray(int[] nums) {
        int n = nums.length;
        int zeroCount = 0;
        int maxLength = 0;
        int left = 0;
        for (int right=0; right<n; right++) {
            if (nums[right] == 0) {
                zeroCount++;
            }
            while (zeroCount > 1) {
                if (nums[left] == 0) {
                    zeroCount--;
                }
                left++;
            }
            maxLength = Math.max(maxLength, right-left);
        }
        return maxLength;
    }
}