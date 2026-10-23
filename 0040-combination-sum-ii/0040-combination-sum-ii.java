class Solution {
    public void solve(int[] candidates, int target, int n, List<List<Integer>> ans, List<Integer> temp, int index) {
        if (target == 0) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index; i<n; i++) {
            if (i > index && candidates[i] == candidates[i-1]) {
                continue;
            }
            if (candidates[index] > target) {
                break;
            }
            temp.add(candidates[i]);
            solve(candidates, target-candidates[i], n, ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        int n = candidates.length;
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        Arrays.sort(candidates);
        solve(candidates, target, n, ans, temp, 0);
        return ans;
    }
}