class Solution {
    public int[] getAverages(int[] nums, int k) {
        int n = nums.length;
        if (k == 0) {
            return nums;
        }
        int[] result = new int[n];
        for (int i=0; i<n; i++) {
            result[i] = -1;
        }
        if (n < 2*k+1) {
            return result;
        }
        int left = 0;
        int right = 2 * k;
        int index = k;
        long sum = 0;
        for (int i=left; i<=right; i++) {
            sum += nums[i];
        }
        result[index] = (int) (sum / (2*k+1));
        index++;
        right++;
        while (right < n) {
            sum += nums[right];
            sum -= nums[left];
            result[index] = (int) (sum / (2*k+1));
            index++;
            left++;
            right++;
        }
        return result;
    }
}