class Solution {
    public int[] leftRightDifference(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        result[0] = 0;
        for (int i=1; i<n; i++) {
            result[i] = result[i-1] + nums[i-1];
        }
        int right = 0;
        for (int i=n-2; i>=0; i--) {
            right += nums[i+1];
            result[i] = Math.abs(result[i] - right);
        }
        return result;
    }
}