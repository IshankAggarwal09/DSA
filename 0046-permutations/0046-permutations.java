class Solution {
    public void solve(int[] nums, int n, List<List<Integer>> ans, List<Integer> temp, boolean[] freq, int index) {
        if (temp.size() == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=0; i<n; i++) {
            if (!freq[i]) {
                freq[i] = true;
                temp.add(nums[i]);
                solve(nums, n, ans, temp, freq, i+1);
                temp.remove(temp.size()-1);
                freq[i] = false;
            }
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        int n = nums.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        boolean[] freq = new boolean[n];
        solve(nums, n, ans, temp, freq, 0);
        return ans;
    }
}