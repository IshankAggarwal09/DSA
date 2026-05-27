class Solution {
    public int smallestDivisor(int[] nums, int threshold) {
        int start = 1;
        int end = 0;
        int ans = -1;
        for (int num : nums) {
            end = Math.max(end, num);
        }
        while (start <= end) {
            int mid = start + (end - start) / 2;
            int result = 0;
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