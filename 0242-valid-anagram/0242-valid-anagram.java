class Solution {
    public boolean isAnagram(String s, String t) {
        int m = s.length();
        int n = t.length();

        // if size of s and size of t are not equal then t can never be anagram of s
        if (m != n) {
            return false;
        }

        // Frequency array to count frequency of characters after adding the count of each character from s and removing the count of each character from t 
        int[] count = new int[26];

        // Iterate through s and t
        for (int i=0; i<m; i++) {
            count[s.charAt(i) - 'a']++; // Increasing the count of current character
            count[t.charAt(i) - 'a']--; // Decreasing the count of current character
        }

        // Iterate through count array
        for (int i=0; i<26; i++) {
            // If frequency is not equal to 0 it means it is not present in either of String s or String t
            if (count[i] != 0) {
                return false;
            } 
        }

        // Otherwise String t is anagram of String s
        return true;
    }
}