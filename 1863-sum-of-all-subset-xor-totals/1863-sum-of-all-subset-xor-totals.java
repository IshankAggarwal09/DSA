class Solution {
    public int solve(int[] nums, int n, int index, List<Integer> temp) {
        if (index == n) {
            int xor = 0;
            for (int i=0; i<temp.size(); i++) {
                xor = xor ^ temp.get(i);
            } 
            return xor;
        }
        temp.add(nums[index]);
        int include = solve(nums, n, index+1, temp);
        temp.remove(temp.size()-1);
        int exclude = solve(nums, n, index+1, temp);
        return include + exclude;
    }
    public int subsetXORSum(int[] nums) {
        int n = nums.length;
        List<Integer> temp = new ArrayList<>();
        return solve(nums, n, 0, temp);
    }
}