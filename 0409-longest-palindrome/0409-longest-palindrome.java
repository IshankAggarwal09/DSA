class Solution {
    public int longestPalindrome(String s) {
        int[] count = new int[128];
        for (char c : s.toCharArray()) {
            count[c]++;
        }
        int answer = 0;
        boolean hasOdd = false;
        for (int i=0; i<128; i++) {
            if (count[i] % 2 == 0) {
                answer += count[i];
            }
            else {
                answer += count[i] - 1;
                hasOdd = true;
            }
        }
        if (hasOdd) {
            answer++;
        }
        return answer;
    }
}