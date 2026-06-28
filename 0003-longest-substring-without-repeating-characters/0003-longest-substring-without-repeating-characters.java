class Solution {
    public int lengthOfLongestSubstring(String s) {
        int[] hash = new int[256];
        for (int i=0; i<256; i++) {
            hash[i] = -1;
        }
        int left = 0;
        int right = 0;
        int maxLen = 0;
        int n = s.length();
        while (right < n) {
            if (hash[s.charAt(right)] != -1) {
                if (hash[s.charAt(right)] >= left) {
                    left = hash[s.charAt(right)] + 1;
                }
            }
            int len = right - left + 1;
            maxLen = Math.max(maxLen, len);
            hash[s.charAt(right)] = right;
            right++;
        }
        return maxLen;
    }
}