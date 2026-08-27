class Solution {
    public int search(int[] nums, int target, boolean isFirstIndex) {
        int n = nums.length;
        int low = 0;
        int high = n-1;
        int ans = -1;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (nums[mid] < target) {
                low = mid + 1;
            }
            else if (nums[mid] > target) {
                high = mid - 1;
            }
            else {
                ans = mid;
                if (isFirstIndex) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }
        }
        return ans;
    }
    public int[] searchRange(int[] nums, int target) {
        int[] ans = {-1, -1};
        ans[0] = search(nums, target, true);
        if (ans[0] != -1) {
            ans[1] = search(nums, target, false);
        }
        return ans;
    }
}