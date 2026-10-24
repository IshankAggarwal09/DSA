class Solution {
    public int solve(int[] nums, int n, int index, int xor) {
        if (index == n) {
            return xor;
        }
        int include = solve(nums, n, index+1, xor^nums[index]);
        int exclude = solve(nums, n, index+1, xor);
        return include + exclude;
    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        return solve(nums, n, 0, 0);
    }
}