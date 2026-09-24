class Solution {
    public int smallestIndex(int[] nums) {
        int n = nums.length;       
        for (int i=0; i<n; i++) {
            int sum = 0;
            int digit = nums[i];
            while (digit > 0) {
                sum = sum + (digit % 10);
                digit = digit / 10;
            }
            if (sum == i) {
                return i;
            }
        }
        return -1;
    }
}