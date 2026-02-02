class Solution {
    public void helper(int k, int target, List<List<Integer>> ans, List<Integer> ds, int idx) {
        if (target == 0) {
            if (k == ds.size()) {
                ans.add(new ArrayList<>(ds));
            }
            return;
        }
        if (target < 0 || ds.size() > k) {
            return;
        }
        for (int i=idx; i<=9; i++) {
            ds.add(i);
            helper(k, target-i, ans, ds, i+1);
            ds.remove(ds.size()-1);
        }
    }
    public List<List<Integer>> combinationSum3(int k, int n) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> ds = new ArrayList<>();
        helper(k, n, ans, ds, 1);
        return ans;
    }
}