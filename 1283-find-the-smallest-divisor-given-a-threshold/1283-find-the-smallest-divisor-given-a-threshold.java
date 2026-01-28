class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int n = nums.length;
        int start = 1;
        int end = 0; 
        for (int num : nums) {
            end = Math.max(end, num);
        }
        int ans = -1;
        while (start <= end) {
            int result = 0;
            int mid = start + (end-start)/2;
            for (int num : nums) {
                result += (num + mid - 1) / mid;
            }
            if (result <= threshold) {
                ans = mid;
                end = mid - 1;
            }
            else {
                start = mid + 1;
            }
        }
        return ans;
    }
}