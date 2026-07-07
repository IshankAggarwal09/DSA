class Solution {
    public int characterReplacement(String s, int k) {
        int[] freq = new int[26];
        int maxLen = 0;
        int maxFreq = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        while (right < n) {
            freq[s.charAt(right) - 'A']++;
            maxFreq = Math.max(maxFreq, freq[s.charAt(right) - 'A']);
            if ((right-left+1) - maxFreq > k) {
                freq[s.charAt(left) - 'A']--;
                left++;
            }
            maxLen = Math.max(maxLen, right-left+1);
            right++;
        }
        return maxLen;
    }
}