class Solution {
    public String smallestPalindrome(String s) {
        char[] arr = s.toCharArray();
        int n = arr.length;
        int[] freq = new int[26];
        for (int i=0; i<n/2; i++) {
            freq[arr[i] - 'a']++;
        }
        int j = 0;
        for (int i=0; i<26; i++) {
            while (freq[i]-- > 0) {
                arr[j] = (char) ('a' + i);
                arr[n - 1 - j] = arr[j];
                j++;
            }
        }
        return new String(arr);
    }
}