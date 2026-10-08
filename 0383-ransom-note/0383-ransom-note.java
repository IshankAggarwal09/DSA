class Solution {
    public boolean canConstruct(String ransomNote, String magazine) {
        int n = ransomNote.length();
        int m = magazine.length();
        if (n > m) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (int i=0; i<n; i++) {
            count1[ransomNote.charAt(i) - 'a']++;
        }
        for (int i=0; i<m; i++) {
            count2[magazine.charAt(i) - 'a']++;
        }
        for (int i=0; i<26; i++) {
            if (count1[i] > 0 && count1[i] > count2[i]) {
                return false;
            }
        }
        return true;
    }
}