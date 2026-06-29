class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] freq = new int[256];
        for (int i=0; i<256; i++) {
            freq[i] = -1;
        }
        int maxLen = 0;
        int left = 0;
        int right = 0;
        int n = s.length();
        while (right < n) {
            if (freq[s.charAt(right)] != -1) {
                if (freq[s.charAt(right)] >= left) {
                    left = freq[s.charAt(right)] + 1;
                }
            }
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            freq[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}