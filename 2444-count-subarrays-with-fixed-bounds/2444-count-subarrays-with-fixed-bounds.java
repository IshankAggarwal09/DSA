class Solution {
    public long countSubarrays(int[] nums, int minK, int maxK) {
        int n = nums.length;
        long answer = 0;
        int minKPosition = -1;
        int maxKPosition = -1;
        int culpritIndex = -1;
        for (int i=0; i<n; i++) {
            if (nums[i] < minK || nums[i] > maxK) {
                culpritIndex = i;
            }
            if (nums[i] == minK) {
                minKPosition = i;
            }
            if (nums[i] == maxK) {
                maxKPosition = i;
            }
            long smaller = Math.min(minKPosition, maxKPosition);
            long temp = smaller - culpritIndex;
            answer += (temp <= 0) ? 0 : temp;
        }
        return answer;
    }
}