class Solution {
    public boolean isVowel(char c) {
        return c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u';
    }
    public int maxVowels(String s, int k) {
        int n = s.length();
        int left = 0;
        int right = 0;
        int maxVowels = 0;
        int count = 0;
        while (right < n) {
            if (isVowel(s.charAt(right))) {
                count++;
            }
            if (right - left + 1 == k) {
                maxVowels = Math.max(maxVowels, count);
                if (isVowel(s.charAt(left))) {
                    count--;
                }
                left++;
            }
            right++;
        }
        return maxVowels;
    }
}