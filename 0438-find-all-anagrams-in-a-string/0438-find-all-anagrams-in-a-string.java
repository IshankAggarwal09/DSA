class Solution {
    public boolean allZero(int[] freq) {
        for (int i=0; i<26; i++) {
            if (freq[i] != 0) {
                return false;
            }
        }
        return true;
    }
    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ans = new ArrayList<>();
        int n = s.length();
        int m = p.length();
        if (m > n) {
            return ans;
        }
        int[] freq = new int[26];
        for (int i=0; i<m; i++) {
            freq[p.charAt(i) - 'a']++;
        }
        int left = 0;
        int right = 0;
        while (right < n) {
            freq[s.charAt(right) - 'a']--;
            if (right - left + 1 == m) {
                if (allZero(freq)) {
                    ans.add(left);
                }
                freq[s.charAt(left) - 'a']++;
                left++;
            }
            right++;
        }
        return ans;
    }
}