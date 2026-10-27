class Solution {
    public int solve(int[] nums, int n, int xor, int index) {
        if (index == n) {
            return xor;
        }
        int include = solve(nums, n, xor^nums[index], index+1);
        int exclude = solve(nums, n, xor, index+1);
        return include + exclude;
    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        return solve(nums, n, 0, 0);
    }
}