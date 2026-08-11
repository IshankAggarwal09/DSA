class Solution {
    public int threeSumClosest(int[] nums, int target) {
        int sum = 0;
        int bestDifference = Integer.MAX_VALUE;
        int closestSum = 0;
        int n = nums.length;
        Arrays.sort(nums);
        for (int i=0; i<n; i++) {
            if (i > 0 && nums[i] == nums[i-1]) {
                continue;
            }
            int j = i+1;
            int k = n-1;
            while (j < k) {
                sum = nums[i] + nums[j] + nums[k];
                if (Math.abs(target - sum) < bestDifference) {
                    bestDifference = Math.abs(target - sum);
                    closestSum = sum;
                }
                if (sum == target) {
                    return sum;
                }
                else if (sum < target) {
                    j++;
                }
                else {
                    k--;
                }
            }
        }
        return closestSum;
    }
}