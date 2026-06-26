class Solution {
    public int countMajoritySubarrays(int[] nums, int target) {
        int n = nums.length;
        int ans = 0;
        for (int left=0; left<n; left++) {
            int targetCount = 0;
            for (int right=left; right<n; right++) {
                if (nums[right] == target) {
                    targetCount++;
                }
                int len = right - left + 1;
                if (targetCount > len / 2) {
                    ans++;
                }
            }
        }
        return ans;
    }
}