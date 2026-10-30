class Solution {
    public boolean isPalindrome(int start, int end, String s) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    public void solve(String s, int n, List<List<String>> ans, List<String> temp, int index) {
        if (index == n) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index; i<n; i++) {
            if (isPalindrome(index, i, s)) {
                temp.add(s.substring(index, i+1));
                solve(s, n, ans, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        int n = s.length();
        solve(s, n, ans, temp, 0);
        return ans;
    }
}