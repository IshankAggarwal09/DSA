class Solution {
    public char next(char chr) {
        return (char) ((chr - 'a' + 1) % 26 + 'a');
    }
    public boolean canMakeSubsequence(String str1, String str2) {
        if (str2.length() > str1.length()) {
            return false;
        }
        int i = 0;
        int j = 0;
        while (i < str1.length() && j < str2.length()) {
            if (str1.charAt(i) == str2.charAt(j)) {
                i++;
                j++;
            }
            else if (next(str1.charAt(i)) == str2.charAt(j)) {
                i++;
                j++;
            }
            else {
                i++;
            }
        }
        if (j < str2.length()) {
            return false;
        }
        return true;
    }
}