class Solution {
    public void solve(int[] candidates, int target, int n, List<List<Integer>> ans, List<Integer> temp, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (target < 0 || index == n) {
            return;
        }
        temp.add(candidates[index]);
        solve(candidates, target-candidates[index], n, ans, temp, index);
        temp.remove(temp.size()-1);
        solve(candidates, target, n, ans, temp, index+1);
    }
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(candidates, target, n, ans, temp, 0);
        return ans;
    }
}