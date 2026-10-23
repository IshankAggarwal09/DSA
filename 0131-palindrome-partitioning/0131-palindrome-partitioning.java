class Solution {
    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    public void solve(String s, List<List<String>> ans, List<String> temp, int index) {
        if (index == s.length()) {
            ans.add(new ArrayList<>(temp));
            return;
        }
        for (int i=index; i<s.length(); i++) {
            if (isPalindrome(s, index, i)) {
                temp.add(s.substring(index, i+1));
                solve(s, ans, temp, i+1);
                temp.remove(temp.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> temp = new ArrayList<>();
        solve(s, ans, temp, 0);
        return ans;
    }
}