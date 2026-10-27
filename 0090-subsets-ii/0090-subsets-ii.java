class Solution {
    public void solve(int[] nums, int n, List<List<Integer>> ans, List<Integer> temp, int index) {
        ans.add(new ArrayList<>(temp));
        for (int i=index; i<n; i++) {
            if (i > index && nums[i] == nums[i-1]) {
                continue;
            }
            temp.add(nums[i]);
            solve(nums, n, ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = nums.length;
        Arrays.sort(nums);
        solve(nums, n, ans, temp, 0);
        return ans;
    }
}