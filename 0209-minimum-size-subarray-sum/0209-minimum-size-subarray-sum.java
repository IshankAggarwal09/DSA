class Solution {
    public int minSubArrayLen(int target, int[] nums) {
        int n = nums.length;
        int left = 0;
        int sum = 0;
        int l = Integer.MAX_VALUE;
        for(int right=left; right<n; right++){
            sum += nums[right];
            while(sum >= target){
                l = Math.min(l, right-left+1);
                sum -= nums[left];
                left++;
            }
        }
        return l != Integer.MAX_VALUE ? l:0;
    }
}