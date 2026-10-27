class Solution {
    public void solve(int n, int k, List<List<Integer>> ans, List<Integer> temp, int index) {
        if (temp.size() == k) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        if (index > n) {
            return;
        }
        for (int i=index; i<=n; i++) {
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