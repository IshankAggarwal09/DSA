class Solution {
    public void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }
    public void solve(int[] nums, int n, List<List<Integer>> ans, int index) {
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
            if (!duplicate) {
                swap(nums, index, i);
                solve(nums, n, ans, index+1);
                swap(nums, index, i);
            }
        }
    }
    public List<List<Integer>> permuteUnique(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        solve(nums, n, ans, 0);
        return ans;
    }
}