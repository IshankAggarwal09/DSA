class Solution {
    public void solve(int[] candidates, int target, List<List<Integer>> ans, List<Integer> temp, int n, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index; i<n; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (candidates[i] > target) {
                break;
            }
            temp.add(candidates[i]);
            solve(candidates, target-candidates[i], ans, temp, n, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        int n = candidates.length;
        Arrays.sort(candidates);
        solve(candidates, target, ans, temp, n, 0);
        return ans;
    }
}