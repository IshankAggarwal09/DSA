class Solution {
    public boolean isPalindrome(String s, int start, int end) {
        while (start <= end) {
            if (s.charAt(start++) != s.charAt(end--)) {
                return false;
            }
        }
        return true;
    }
    public void helper(String s, List<List<String>> ans, List<String> path, int idx) {
        if (idx == s.length()) {
            ans.add(new ArrayList<>(path));
            return;
        }
        for (int i=idx; i<s.length(); i++) {
            if (isPalindrome(s, idx, i)) {
                path.add(s.substring(idx, i+1));
                helper(s, ans, path, i+1);
                path.remove(path.size()-1);
            }
        }
    }
    public List<List<String>> partition(String s) {
        List<List<String>> ans = new ArrayList<>();
        List<String> path = new ArrayList<>();
        helper(s, ans, path, 0);
        return ans;
    }
}