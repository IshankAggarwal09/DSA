class Solution {
    public void solve(int n, int k, List<List<Integer>> ans, List<Integer> temp, int start) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (start > n) {
            return;
        }
        for (int i=start; i<=n; i++) {
            temp.add(i);
            solve(n, k, ans, temp, i+1);
            temp.remove(temp.size()-1);
        }
    }
    public List<List<Integer>> combine(int n, int k) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> temp = new ArrayList<>();
        solve(n, k, ans, temp, 1);
        return ans;
    }
}