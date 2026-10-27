class Solution {
    public void solve(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int n, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || index == n) {
            return;
        }
        temp.add(candidates[index]);
        solve(candidates, target-candidates[index], ans, temp, n, index);
        temp.remove(temp.size()-1);
        solve(candidates, target, ans, temp, n, index+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;
        solve(candidates, target, ans, temp, n, 0);
        return ans;
    }
}