class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[256];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int answer = 0;
        boolean hasOdd = false;
        for (int i=0; i<256; i++) {
            answer += (count[i] / 2) * 2;
            if (count[i] % 2 == 1) {
                hasOdd = true;
            }
        }
        if (hasOdd) {
            answer++;
        }
        return answer;
    }
}