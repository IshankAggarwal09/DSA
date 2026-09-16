class Solution {
    public void checkPalindrome(char[] ch, int left, int right, int[] max) {
        while (left >= 0 && right < ch.length && ch[left] == ch[right]) {
            left--;
            right++;
        }
        left++;
        right--;
        if (right - left + 1 > max[0]) {
            max[0] = right - left + 1;
            max[1] = left;
            max[2] = right;
        }
    }
    public String longestPalindrome(String s) {
        char[] ch = s.toCharArray();
        int n = s.length();
        int[] max = new int[3];
        for (int i=0; i<n; i++) {
            checkPalindrome(ch, i, i, max);
            checkPalindrome(ch, i, i+1, max);
        }
        return s.substring(max[1], max[2]+1);
    }
}