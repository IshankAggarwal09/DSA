class Solution {
    public void swap(int i, int j, int[] nums) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void solve(int[] nums, List<List<Integer>> ans, int n, int index) {
        if (index == n) {
            List<Integer> temp = new ArrayList<>();
            for (int i=0; i<n; i++) {
                temp.add(nums[i]);
            }
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index; i<n; i++) {
            boolean duplicate = false;
            for (int j=index; j<i; j++) {
                if (nums[i] == nums[j]) {
                    duplicate = true;
                    break;
                }
            }
            if (duplicate) {
                continue;
            }
            swap(i, index, nums);
            solve(nums, ans, n, index+1);
            swap(i, index, nums);
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        int n = nums.length;
        solve(nums, ans, n, 0);
        return ans;
    }
}