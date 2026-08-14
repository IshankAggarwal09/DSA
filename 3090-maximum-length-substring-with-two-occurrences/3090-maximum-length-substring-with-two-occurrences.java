class Solution {
    public int maximumLengthSubstring(String s) {
        int[] freq = new int[26];
        int start = 0;
        int maxlen = 0;
        for (int end=0; end<s.length(); end++) {
            freq[s.charAt(end) - 'a']++;
            while (freq[s.charAt(end) - 'a'] > 2) {
                freq[s.charAt(start) - 'a']--;
                start++;
            }
            maxlen = Math.max(maxlen, end - start + 1);
        }
        return maxlen;
    }
}