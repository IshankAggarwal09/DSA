class Solution {
    public void solve(int[] nums, int n, List<List<Integer>> ans, List<Integer> temp, int index) {
        if (index == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        temp.add(nums[index]);
        solve(nums, n, ans, temp, index+1);
        temp.remove(temp.size()-1);
        solve(nums, n, ans, temp, index+1);
    }
    public List<List<Integer>> subsets(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(nums, n, ans, temp, 0);
        return ans;
    }
}