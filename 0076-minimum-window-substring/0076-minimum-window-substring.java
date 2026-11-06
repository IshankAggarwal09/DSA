class Solution {
    public String minWindow(String s, String t) {
        int n = s.length();
        int m = t.length();
        if (m > n) {
            return "";
        }
        int[] freq = new int[256];
        for (char c : t.toCharArray()) {
            freq[c]++;
        }
        int requiredCount = m;
        int left = 0;
        int right = 0;
        int windowSize = Integer.MAX_VALUE;
        int sIndex = -1;
        while (right < n) {
            char ch = s.charAt(right);
            if (freq[ch] > 0) {
                requiredCount--;
            }
            freq[ch]--;
            while (requiredCount == 0) {
                if (windowSize > right - left + 1) {
                    windowSize = right - left + 1;
                    sIndex = left;
                }
                freq[s.charAt(left)]++;
                if (freq[s.charAt(left)] > 0) {
                    requiredCount++;
                }
                left++;
            }
            right++;
        }
        return windowSize == Integer.MAX_VALUE ? "" : s.substring(sIndex, sIndex + windowSize);
    }
}