class Solution {
    public boolean isAnagram(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }
        int[] count1 = new int[26];
        int[] count2 = new int[26];
        for (char ch : s.toCharArray()) {
            count1[ch - 'a']++;
        }
        for (char ch : t.toCharArray()) {
            count2[ch - 'a']++;
        }
        if (Arrays.equals(count1, count2)) {
            return true;
        }
        return false;
    }
}