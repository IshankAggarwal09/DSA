class Solution {
    public void solve(int n, List<String> ans, String s, int left, int right) {
        if (right == n) {
            ans.add(s);
            return;
        }
        if (left < n) {
            solve(n, ans, s+"(", left+1, right);
        }
        if (right < left) {
            solve(n, ans, s+")", left, right+1);
        }
    }
    public List<String> generateParenthesis(int n) {
        List<String> ans = new ArrayList<>();
        solve(n, ans, "", 0, 0);
        return ans;
    }
}